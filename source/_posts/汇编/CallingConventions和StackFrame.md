---
title: Calling Conventions和Stack Frame
categories:
	- 汇编
	- ABI
	- Linux
---
# x64 Linux Calling Conventions

参数从左到右，传递尽可能多的参数以适应寄存器，寄存器的分配顺序为：

* 对于整数和指针：rdi，rsi，rdx，rcx，r8，r9（dsdc89）
* 对于浮点数（float和double）：xmm0，xmm1，xmm2，xmm3，xmm4，xmm5，xmm6，xmm7（xmm0-7）

dsdc89可以适应不同类型的参数：
![dsdc89.png](../images/dsdc89.png?raw=true)

ps:如果参数中同时存在integer，pointer和float时，前两者按顺序使用dsdc89，后者按顺序使用xmm0-7.

* 如果参数太多，无法用register传递的时候，多出来的参数走stack，从右到左压栈，caller清栈
* stack上的参数，每个都占8字节
* 最后push返回地址
* 当callee获得控制权，返回地址的位置[rsp]，如果有压栈参数，第一个压栈参数位置[rsp+8]
* 参数推送后，发出调用指令，因此当被调用函数获得控制权时，返回地址在（%rsp），第一个内存参数在（%rsp+8），以此类推。
* 在进行调用之前，堆栈指针 %RSP 必须与 16 字节边界对齐。但是进行调用的过程会将返回地址（8 个字节）推送到堆栈上，因此当函数获得控制权时，%rsp 不会对齐。你必须自己腾出额外的空间，通过推送一些东西或从 %rsp 中减去 8。
* 被调用函数需要保留的寄存器（被调用者保存寄存器）包括：rbp、rbx、r12、r13、r14、r15。所有其他函数都可以由调用函数自由更改，这些函数称为调用方保存寄存器。
* 所有xmm寄存器都属于caller-save！callee可以随便使用。

所谓callee-save寄存器，表示这些寄存器的值，对于caller来说，不会被callee破坏，这些值在call指令前后不会变化，可以放心继续使用，不需要自己做push和pop。而caller-save寄存器，在call前后，不能保证其值不会变化，如果要在call之后继续使用，需要caller自己做push和pop。对于用于传参的dsdc89，它们都是caller-save寄存器。callee-saved寄存器，有可能会被每一层push和pop

# Linux Stack Frame Layout on x64

根据ABI描述，前6个integer或者指针参数传递进寄存器，第一个传入rdi，第二个传入rsi，之后是rdx，rcx，r8，r9。第七个开始的参数传入栈中

```c
long myfunc(long a, long b, long c, long d,
            long e, long f, long g, long h)
{
    long xx = a * b * c * d * e * f * g * h;
    long yy = a + b + c + d + e + f + g + h;
    long zz = utilfunc(xx, yy, xx % yy);
    return zz + 20;
}
```

![stack_frame.png](../images/stack_frame.png?raw=true)

前6个参数通过寄存器传递，除开这些，和x86没啥区别。
简单地说，红色区域是一种优化。代码可以假设 rsp 以下的 128 个字节不会被信号或中断处理程序异步破坏，因此可以将其用于暂存数据，而无需显式移动堆栈指针。最后一句话是优化所在 - 减少 rsp 和恢复它是使用红色区域获取数据时可以保存的两条指令。

```c
long utilfunc(long a, long b, long c)
{
    long xx = a + 2;
    long yy = b + 3;
    long zz = c + 4;
    long sum = xx + yy + zz;

    return xx * yy * zz + sum;
}
```

使用gcc编译后：
![red_zone.png](../images/red_zone.png?raw=true)

由于utilfunc只有三个参数，不需要通过stack去传递参数。gcc 选择将红色区域用于其所有局部变量。因此，不需要递减（然后恢复）rsp 来为此数据分配空间。

基本指针 rbp（及其前身 epp）在函数的整个执行过程中是堆栈帧开头的稳定“锚点”，对于手动汇编编码和调试非常方便。然而，前段时间人们注意到编译器生成的代码并不真正需要它（编译器可以很容易地跟踪 rsp 的偏移量），并且 DWARF 调试格式提供了在没有基本指针的情况下访问堆栈帧的方法 （CFI）。

这就是为什么一些编译器开始省略基本指针以进行积极优化的原因，从而缩短了函数序言和尾声，并为通用用途提供了额外的寄存器（回想一下，这在 x86 上非常有用，其 GPR 集有限）。

默认情况下，GCC 在 x86 上保留基本指针，但允许使用 -fomit-frame-pointer 编译标志进行优化。如何推荐使用此标志是一个有争议的问题 - 如果您对此感兴趣，您可以进行一些谷歌搜索。

# Stack的16字节对齐

x64架构下，ABI要求stack的16字节对齐。
64位CPU，并不意味着每次存取8字节才是最快的，64只是寄存器的大小。而且，已经存在128位的寄存器在x64的架构中。不对齐的后果是，效率低，很多call会发生segmentation failt。
任何内存分匹配函数（malloc，calloc或realloc）生成的块其实地址都必须是16的倍数

# Windows在x64下的ABI

https://learn.microsoft.com/en-us/windows-hardware/drivers/debugger/x64-architecture

Unlike the x86, the C/C++ compiler only supports one calling convention on x64. This calling convention takes advantage of the increased number of registers available on x64:

The first four integer or pointer parameters are passed in the rcx, rdx, r8, and r9 registers.
The first four floating-point parameters are passed in the first four SSE registers, xmm0-xmm3.
The caller reserves space on the stack for arguments passed in registers. The called function can use this space to spill the contents of registers to the stack.
Any additional arguments are passed on the stack.
An integer or pointer return value is returned in the rax register, while a floating-point return value is returned in xmm0.
rax, rcx, rdx, r8-r11 are volatile. （我理解函数代码可以自由使用这些寄存器）
rbx, rbp, rdi, rsi, r12-r15 are nonvolatile. （我理解函数代码如果要使用这些寄存器，需要先push，最后pop）
The calling convention for C++ is very similar: the this pointer is passed as an implicit first parameter. The next three parameters are passed in remaining registers, while the rest are passed on the stack.

The Windows x64 ABI

Windows on x64 implements an ABI of its own, which is somewhat different from the AMD64 ABI. I will only discuss the Windows x64 ABI briefly, mentioning how its stack frame layout differs from AMD64. These are the main differences:

Only 4 integer/pointer arguments are passed in registers (rcx, rdx, r8, r9).
There is no concept of "red zone" whatsoever. In fact, the ABI explicitly states that the area beyond rsp is considered volatile and unsafe to use. The OS, debuggers or interrupt handlers may overwrite this area.
Instead, a "register parameter area" is provided by the caller in each stack frame. When a function is called, the last thing allocated on the stack before the return address is space for at least 4 registers (8 bytes each). This area is available for the callee's use without explicitly allocating it. It's useful for variable argument functions as well as for debugging (providing known locations for parameters, while registers may be reused for other purposes). Although the area was originally conceived for spilling the 4 arguments passed in registers, these days the compiler uses it for other optimization purposes as well (for example, if the function needs less than 32 bytes of stack space for its local variables, this area may be used without touching rsp).
Another important change that was made in the Windows x64 ABI is the cleanup of calling conventions. No more cdecl/stdcall/fastcall/thiscall/register/safecall madness - just a single "x64 calling convention". Cheers to that!

更多资料：

https://learn.microsoft.com/en-us/cpp/build/x64-software-conventions

https://stackoverflow.com/questions/4429398/why-does-windows64-use-a-different-calling-convention-from-all-other-oses-on-x86
