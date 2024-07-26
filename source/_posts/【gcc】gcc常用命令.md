# 基本命令
gcc的基本语法是
```shell
gcc [options] [filename]
```

其中options表示参数，[filename]表示相关文件的名称

## -x language filename
设定文件的语言，使后缀名无效，对之后的后缀名做同样的处理，语言类型有c,objective-c,c-header,c++,cpp-output,assembler和assembler-with-cpp
```shell
gcc -x c hello.pig
```

## -x none file
关闭上一个选项，也就是让gcc根据文件名后缀，自动识别文件类型
```shell
gcc -x c hello.pig -x none hello2.c
```

## -c
只激活预处理，编译和汇编，也就是他只把程序做成obj文件,下面命令将会生成.o的obj文件
```shell
gcc -c hello.c
```

## -S 
只激活预处理和编译，就是把文件编译成汇编代码，下面命令将会生成汇编代码，可以使用文本编辑器查看
```shell
gcc -S hello.c
```

## -E
只激活预处理,这个命令不生成文件，需要将输出重定向到一个文件内
```shell
gcc -E hello.c > pianoapan.txt
gcc -E hello.c | more
```
## -o
指定目标文件名称，默认的名字是a.out
```shell
gcc -o hello hello.c
gcc -o hello.asm -S hello.c
```

## -pipe
使用管道替代编译中的临时文件，在使用非gnu汇编工具的时候，可能有问题
```shell
gcc -pipe -o hello hello.c
```

## -ansi
关闭gnu c中与ansi c不兼容的特性，只激活ansi c的专有特性（包括asm inline typeof关键字，以及unix，vax 等预处理宏)

## -fno-asm
实现-ansi选项的部分功能，禁止asm，inline何typeof用作关键字

## fno-strict-prototype
只对g++起作用，使用这个选项，g++ 将对不带参数的函数，都认为是没有显示的对参数的个数和类型说明，而不是没有参数。无论gcc是否使用这个参数，都将对没有带参数的函数，认为成没有显示说明的类型。

## -fthis-is-variable
向传统C++看齐，可以使用this当一般变量使用

## fcond-mismatch
允许条件表达式的第二和第三参数类型不匹配，表达式的值将为void类型

## -funsigned-char,-fnp-signed-char,-fsigned-char,-fno-unsigned-char
这四个参数是对char类型进行设置，决定将char类型设置成unsigned char(前两参数) 或者 signed char(后两参数)

## -include file
相当于 #include <file>
```shell
gcc hello.c -include /root/pianopan.h
```

## -imacros file
将file文件的宏，扩展到gcc/g++的输入文件，宏定义本身并不出现在输入文件中

## -Dmacro
相当于C语言中的 #define macro

## -Dmacro=defn
相当于C语言中的 #define macro=defn

## -Umacro
相当于C语言中的#undef macro

## -undef
取消对任何非标准宏的定义

## -Idir
在你使用 #include "file" 的时候，gcc/g++会在当前目录查找你所指定的头文件，如果没有找到，他回到默认的头文件目录找，如果使用 -I指定目录，他会现在指定的目录找，然后再按常规的顺序查找

## -I-
取消-Idir

## -idirafter dir
在-I的目录查找失败，就到这个目录里面查找

## -iprefix prefix , -iwithprefix dir
一般一起使用，如果-I的目录查找失败，会到prefix+dir下面查找

## --nostdinc
使编译器不在系统默认的头文件目录里面找头文件，一般和-I联合使用，明确限定头文件的位置

## -nostdin C++
规定不在g++指定的标准路径中搜索，但仍在其他的路径中搜索，此选项在创libg++库使用

## -C
在预处理的时候，不删除注释信息，一般和-E使用，有时候分析程序，用这个很方便

## -M
生成文件关联的信息。包含目标文件所依赖的所有源代码你可以使用
```shell
gcc -M hello.c
```

## -MM
和上面的那个一样，但是这个命令将忽略第二层的依赖关系，简单来说就是--depth=1

## -MD
和-M相同，但是将输出导入到.d文件里面

## -MMD
和-MM相同，但是输出导入到.d的文件里面

## -Wa,option
此选项将传递option选项给汇编程序，如果option中间有逗号，就将option分成多个选项，然后传递给汇编程序

## -Wl,option
此选项将传递option选项给链接程序，如果option中间有逗号，就将option分成多个选项，然后传递给连接程序

## -llibrary
指定编译的时候使用的库
```shell
# 指定使用math库
gcc -lm hello.c
```

## -Ldir
指定编译的时候，搜索库的路径。否则编译只会在标准库路径查找

## -O0,-O1,-O2,-O3
编译器的优化选项的4个级别，0没有优化，1默认值，3最高级别

## -g
指示编译器，在编译的时候，产生调试信息

## -gstabs
此选项已stabs格式声明调试信息，但是不包括gdb调试信息

## -gstabs+
此选项以stabs格式声明调试信息，并且包含仅供gdb使用的额外调试信息

## -ggdb
此选项将尽可能的生成gdb的可以使用的调试信息


## -static
此选项将禁止使用动态库，所以编译出来的东西一般很大，也不需要使用动态链接库，就可以运行

## -share
此选项将尽量使用动态库，所以生成的文件比较小，但是需要系统提供动态库

## -traditional
试图让编译器支持传统的C语言特性



