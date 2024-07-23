---
title: C语言static关键字
categories:
      - C语言
      - static关键字
---

# C语言static关键字
static关键字总共有三个左右：
1. 隐藏变量、函数
2. 静态变量只会在程序启动时初始化一次
3. 静态变量存储在静态数据区，初始化为零（全局变量也是）

# 隐藏变量、函数

```c
// add.c
static int num1 = 10;

int num2 = 11;

static int dec(int num)
{
    return num - 1;
}

int inc(int num)
{
    return num + 1;
}

// main.c
#include <stdio.h>

extern int num2;
extern int num1;

extern int dec(int num);
extern int inc(int num);

int main(int argc, char const *argv[])
{
    printf("dec num2:%d\n", dec(num2));
    printf("inc num2:%d\n", inc(num2));
    printf("dec num1:%d\n", dec(num1));
    printf("inc num1:%d\n", inc(num1));
    return 0;
}
```
使用下面命令进行编译
```shell
gcc -fPIC --shared add.c -o libadd.so
gcc -o main -ladd -L.  main.c
```
在编译main函数的时候会出现报错
```
/tmp/ccyQQGQI.o: In function `main':
main.c:(.text+0x18): undefined reference to `dec'
main.c:(.text+0x4d): undefined reference to `num1'
main.c:(.text+0x54): undefined reference to `dec'
main.c:(.text+0x6b): undefined reference to `num1'
collect2: error: ld returned 1 exit status
```
由上面的报错可以看到static变量num1和函数dec是无法被看见的

# 静态变量只会在程序启动时初始化一次
实现以下函数
```c
#include <stdio.h>

int func()
{
    static int num = 10;
    return num--;
}

int main(int argc, char const *argv[])
{
    for (size_t i = 0; i < 10; i++) {
        printf("%d --- %d\n", i, func());
    }
    return 0;
}
```

程序输出如下：
```
0 --- 10
1 --- 9
2 --- 8
3 --- 7
4 --- 6
5 --- 5
6 --- 4
7 --- 3
8 --- 2
9 --- 1
```

从输出可以看到static int num = 10 的赋值语句只会在第一次进入的时候进行赋值

# 静态变量存储在静态数据区，初始化为零
```c
#include <stdio.h>

static int num;

int main(int argc, char const *argv[])
{
    printf("num define init value:%d\n", num);
    return 0;
}
```
程序输出如下
```
num define init value:0
```
