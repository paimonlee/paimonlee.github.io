---
title: JNI开发
categories:
    - 开发手册
---


# JNI 接口开发步骤
Java可以通过以下五个步骤创建native接口，调用C语言函数接口
1. 编写Java的类，声明native接口
2. 通过本地接口类，生成对接C头文件
3. 实现C头文件接口
4. 使用C编译器编译生成动态链接库
5. 加载动态库，调用C接口函数


# 1、声明本地接口
Java使用native声明本地接口

```java
public class AddNative {
    public native int add(int a, int b);
}
```
# 2、生成C头文件
使用命令在当前文件夹下面生成AddNative.h头文件
```shell
javac AddNative.java -h ./
```
生成的头文件内容如下
```C
/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class AddNative */

#ifndef _Included_AddNative
#define _Included_AddNative
#ifdef __cplusplus
extern "C"
{
#endif
/*
  * Class:     AddNative
  * Method:    add
  * Signature: (II)I
  */
JNIEXPORT jint JNICALL Java_AddNative_add(JNIEnv *, jobject, jint, jint);

#ifdef __cplusplus
}
#endif
#endif
```
头文件引入的jni.h和jni_md.h在jdk目录下的include和include/linux下
# 3、实现文件接口
创建AddNative.c文件，将生成的头文件内的接口全部实现
```C
#include "AddNative.h"

JNIEXPORT jint JNICALL Java_AddNative_add(JNIEnv *env, jobject thiz, jint a, jint b)
{
    return a + b;
}
```
# 4、编译生成动态链接库
使用命令编译生成动态库
```shell
gcc -shared -I ./ -I $JAVA_HOME/include -I $JAVA_HOME/include/linux AddNative.c -o libaddnative.so
```
# 5、加载动态库，通过java调用本地接口
编写下面测试代码调用c接口
```java
class Main {
    static {
        System.load("/home/l30042404/workspace/c-leetcode/src/libaddnative.so");
    }

    public static void main(String[] args) {
        AddNative addNative = new AddNative();
        System.err.println("res:" + addNative.add(1, 2));
    }
}
```
运行代码，输出 res:3


# 问题记录

## 内存泄露
从jstring对象中拿取字符串对象后，需要对拿取到的字符串指针释放，否则会出现内存泄露
```c
char * string = (*env)->GetStringUTFChars(env, str, false);
(*env)->ReleaseStringUTFChars(env, str, string);
```
