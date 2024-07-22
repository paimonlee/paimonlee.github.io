---
title: c++基础语法
categories:
    - c++
    - 编程语言
---
# C++类型限定符

| 限定符   | 含义                                                                                       |
| -------- | ------------------------------------------------------------------------------------------ |
| const    | const定义常量，表示该变量的值不能被修改                                                    |
| volatile | 修饰符volatile告诉该变量的值可能被程序以外的因素修改，如硬件或其他线程                     |
| restrict | 由restrict修饰的指针是唯一一种访问它所指向的对象的方式                                     |
| static   | 用于定义静态变量，表示该变量的作用域仅限于当前文件或当前函数内，不会被其他文件或者函数访问 |
| register | 用于定义寄存器变量，表示该变量被频繁使用，可以存储在CPU的寄存器内，以提高程序的运行效率    |

# 存储类

存储类定义C++程序中变量/函数的范围（可见）和声明周期。这些说明符放置在他们所修饰的类型之前。下列C++程序中可用的存储类

## static

static 存储类指示编译器在程序的生命周期内保持局部变量的存在，而不需要在每次他进入和离开作用域时进行创建和销毁。因此，使用static修复局部变量可以在函数调用之间保持局部变量的值。

static修饰符也可以应用于全局变量，当static修饰全局变量的时候，会使变量的作用域限制在它的文件内。

static修饰符也可以应用于全局变量。当static修饰全局变量时，会使变量的作用域限制在声明它的文件内。

在C++中，当static用在类数据成员上时，会导致仅有一个该成员的副本被类的所有对象共享。

```c++
#include <iostream>

void func(void);

static int count = 10; /*全局变量*/
int        main()
{
    while (count--) {
        func();
    }
    return 0;
}

void func(void)
{
    static int i = 5;
    i++;
    std::cout << "变量i为" << i;
    std::cout << "，变量count为" << count << std::endl;
}

```

## extern 存储类

extern存储类用于提供一个全局变量的引用，全局变量对所有的程序都是可见的。当使用extern时，对于无法初始化的变量，会把变量名指向一个之前定义过的存储位置。

当有多个文件且定义了一个可以在其他文件中使用的全局变量或函数时，可以在其他文件中使用extern来得到已定义的变量或函数的引用。可以理解为，extern是用来在另一个文件中声明一个全局变量或函数。

extern 修饰符通常用于当有两个或者多个文件共享相同的全局变量或者函数的时候

```c++
#include <iostream>
int         count;
extern void write_extern();

int main()
{
    count = 5;
    write_extern();
}

```

## mutable存储类

mutable 说明符仅使用于类的对象。它允许对象的成员替代常量。也就是说，mutable成员可以通过const成员函数修改

## thread_local 存储类

使用thread_local说明符声明的变量仅可以在它在创建其上创建的线程上访问。变量在创建线程时创建，并在销毁线程时销毁。每个线程都有自己的变量副本。

thread_local 说明符可以与static 或 extern 合并

thread_local仅用于数据声明和定义，thread_local不能用于函数声明或定义。

```c++
thread_local int x;

class X {
    static thread_local std::string s;
};

static thread_local std::string X::s;

void foo() {
    thread_local std::vector<int> v;
}
```

# 类定义

```c++
#include <iostream>

using namespace std;

class Box {
    double length;

  public:
    double breadth;
    double height;
    double get(void);
    void   set(double len, double bre, double hei);

  public:
    friend void printLength(Box box);
};

double Box::get(void) { return length * breadth * height; }

void Box::set(double len, double bre, double hei)
{
    this->length  = len;
    this->breadth = bre;
    this->height  = hei;
}

void printLength(Box box) { cout << "Width of box : " << box.length << endl; }
```

## 内联函数

inline 定义在函数名前，就是内联函数，弱国函数多于一行，就会忽略inline限定符

```c++
#include <iostream>

using namespace std;

inline int Max(int x, int y)
{
    return (x > y)? x : y;
}
```

## 类继承

一个类可以继承多个类。派生类的语法如下

```c++
class derived-class: access-specifier base-class
```

```c++
#include <iostream>
 
using namespace std;
 
// 基类
class Shape 
{
   public:
      void setWidth(int w)
      {
         width = w;
      }
      void setHeight(int h)
      {
         height = h;
      }
   protected:
      int width;
      int height;
};
 
// 派生类
class Rectangle: public Shape
{
   public:
      int getArea()
      { 
         return (width * height); 
      }
};
```

### 访问控制和继承

派生类可以访问基类中所有的非私有成员。因此基类成员如果不想被派生类的成员函数访问，则应在基类中声明为 private。

我们可以根据访问权限总结出不同的访问类型，如下所示：

| 访问     | public | protected | private |
| -------- | ------ | --------- | ------- |
| 同一个类 | yes    | yes       | yes     |
| 派生类   | yes    | yes       | no      |
| 外部的类 | yes    | no        | no      |

一个派生类继承了所有的基类方法，但下列情况除外：

* 基类的构造函数、析构函数和拷贝构造函数。
* 基类的重载运算符。
* 基类的友元函数。

### 继承类型

当一个类派生自基类，该基类可以被继承为 public、protected 或 private 几种类型。继承类型是通过上面讲解的访问修饰符 access-specifier 来指定的。

我们几乎不使用 protected 或 private 继承，通常使用 public 继承。当使用不同类型的继承时，遵循以下几个规则：

* 公有继承（public）：当一个类派生自公有基类时，基类的公有成员也是派生类的公有成员，基类的保护成员也是派生类的保护成员，基类的私有成员不能直接被派生类访问，但是可以通过调用基类的公有和保护成员来访问。
* 保护继承（protected）： 当一个类派生自保护基类时，基类的公有和保护成员将成为派生类的保护成员。
* 私有继承（private）：当一个类派生自私有基类时，基类的公有和保护成员将成为派生类的私有成员。

### 多继承

```c++
class <派生类名>:<继承方式1><基类名1>,<继承方式2><基类名2>,…
{
<派生类类体>
};
```

# 运算符重载

可以重定义或者重载大部分c++内置的运算符，这样就可以使用自定义的类型运算符

重载运算符是带有特殊名称的函数，函数名是由关键字operator和其后要重载的运算符符号构成，与其他函数一样，重载运算符有一个返回类型和一个参数列表

```c++
Box operator+(const Box&, const Box&);

#include <iostream>

using namespace std;

class Box {
    double length;

  public:
    double breadth;
    double height;
    double get(void) { return length * breadth * height; }
    void   set(double len, double bre, double hei)
    {
        this->length  = len;
        this->breadth = bre;
        this->height  = hei;
    }

  public:
    friend void printLength(Box box) { cout << "Width of box : " << box.length << endl; }

    Box operator+(const Box &b)
    {
        Box box;
        box.length  = this->length + b.length;
        box.breadth = this->breadth + b.breadth;
        box.height  = this->height + b.height;
        return box;
    }
};

```

可重载的运算符列表：

|                |                                                                         |
| -------------- | ----------------------------------------------------------------------- |
| 双目算术运算符 | + (加)，-(减)，*(乘)，/(除)，% (取模)                                   |
| 关系运算符     | ==(等于)，!= (不等于)，< (小于)，> (大于)，<=(小于等于)，>=(大于等于)   |
| 逻辑运算符     | \|\|(逻辑或)，&&(逻辑与)，!(逻辑非)                                     |
| 单目运算符     | + (正)，-(负)，*(指针)，&(取地址)                                       |
| 自增自减运算符 | ++(自增)，--(自减)                                                      |
| 位运算符       | \| (按位或)，& (按位与)，~(按位取反)，^(按位异或),，<< (左移)，>>(右移) |
| 赋值运算符     | =, +=, -=, *=, /= , % = , &=,                                           |
| 空间申请与释放 | new, delete, new[ ] , delete[]                                          |
| 其他运算符     | ()(函数调用)，->(成员访问)，,(逗号)，\[\](下标)                         |

不可重载的运算符列表：

* .：成员访问运算符
* .*, ->*：成员指针访问运算符
* ::：域运算符
* sizeof：长度运算符
* ?:：条件运算符
* #： 预处理符号
* 运算符重载实例

# 多态

```c++
#include <iostream> 
using namespace std;
 
class Shape {
   protected:
      int width, height;
   public:
      Shape( int a=0, int b=0)
      {
         width = a;
         height = b;
      }
      virtual int area()
      {
         cout << "Parent class area :" <<endl;
         return 0;
      }
};
class Rectangle: public Shape{
   public:
      Rectangle( int a=0, int b=0):Shape(a, b) { }
      int area ()
      { 
         cout << "Rectangle class area :" <<endl;
         return (width * height); 
      }
};
class Triangle: public Shape{
   public:
      Triangle( int a=0, int b=0):Shape(a, b) { }
      int area ()
      { 
         cout << "Triangle class area :" <<endl;
         return (width * height / 2); 
      }
};
```

## 虚函数

虚函数 是在基类中使用关键字 virtual 声明的函数。在派生类中重新定义基类中定义的虚函数时，会告诉编译器不要静态链接到该函数。

我们想要的是在程序中任意点可以根据所调用的对象类型来选择调用的函数，这种操作被称为动态链接，或后期绑定。

## 纯虚函数

您可能想要在基类中定义虚函数，以便在派生类中重新定义该函数更好地适用于对象，但是您在基类中又不能对虚函数给出有意义的实现，这个时候就会用到纯虚函数。

我们可以把基类中的虚函数 area() 改写如下：

```c++
class Shape {
   protected:
      int width, height;
   public:
      Shape( int a=0, int b=0)
      {
         width = a;
         height = b;
      }
      // pure virtual function
      virtual int area() = 0;
};
```

# c++接口(抽象类)

接口描述了类的行为和功能，而不需要类的特定实现。

C++接口时使用抽象类来实现的，抽象类与数据抽象互补混淆,数据抽象是吧一个实现细节与相关的数据分离开来的概念。

如果类中至少有一个函数被声明为纯虚函数，则这个类就是抽象类，纯虚函数是通过在声明中使用"=0"来指定的。

# 异常处理

异常是程序在执行期间产生的问题。C++ 异常是指在程序运行时发生的特殊情况，比如尝试除以零的操作。

异常提供了一种转移程序控制权的方式。C++ 异常处理涉及到三个关键字：try、catch、throw。

* throw: 当问题出现时，程序会抛出一个异常。这是通过使用 throw 关键字来完成的。
* catch: 在您想要处理问题的地方，通过异常处理程序捕获异常。catch 关键字用于捕获异常。
* try: try 块中的代码标识将被激活的特定异常。它后面通常跟着一个或多个 catch 块。

## 抛出异常

```c++
double division(int a, int b)
{
   if( b == 0 )
   {
      throw "Division by zero condition!";
   }
   return (a/b);
}
```

## 捕获异常

```c++
try
{
   // 保护代码
}catch( ExceptionName e )
{
  // 处理 ExceptionName 异常的代码
}

try
{
   // 保护代码
}catch(...)
{
  // 能处理任何异常的代码
}
```

# 动态内存

## new和delete运算符

```c++
创建对象，new 会调用构造函数
new data-type;
销毁对象，delete会调用析构函数
delete pvalue;
```

# 命名空间

命名空间用附加信息来区分不同库中相同名称的函数、类、变量等。使用命名空间即定义了上下文，

## 定义命名空间

```c++
namespace namespace_name{
    // 代码声明
}

# 调用
name::code;


#include <iostream>
using namespace std;
 
// 第一个命名空间
namespace first_space{
   void func(){
      cout << "Inside first_space" << endl;
   }
}
// 第二个命名空间
namespace second_space{
   void func(){
      cout << "Inside second_space" << endl;
   }
}
int main ()
{
 
   // 调用第一个命名空间中的函数
   first_space::func();
   
   // 调用第二个命名空间中的函数
   second_space::func(); 
 
   return 0;
}
```

## using指令

使用using namespace指令，这样在使用命名空间的时候就可以不用在前面加上命名空间的名称。这个指令会告诉编译器，后续的代码将使用指定的命名空间的名称。

```c++
#include <iostream>
using namespace std;
 
// 第一个命名空间
namespace first_space{
   void func(){
      cout << "Inside first_space" << endl;
   }
}
// 第二个命名空间
namespace second_space{
   void func(){
      cout << "Inside second_space" << endl;
   }
}
using namespace first_space;
int main ()
{
 
   // 调用第一个命名空间中的函数
   func();
   
   return 0;
}
```
