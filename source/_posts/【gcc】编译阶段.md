# 1、预处理
替换头和宏定义
```shell
gcc -E main.c -o main.i
```
# 2、汇编
将预处理之后的代码转换为汇编代码
```shell
gcc -S main.i -o main.s
```

# 3、编译
将汇编代码转换为二进制码
```shell
gcc -c main.s -o main.o
```

# 4、链接
将经编译好的二进制文件链接对应的库链接，否则程序是无法运行的
```shell
gcc main.o -o main
```