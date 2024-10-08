---
title: read、readarray、mapfile
categories:
	- shell
	- shell命令
---
# read

从标准输入读取一行输入，存入指定变量

常用参数

* -s 静默模式，不回显输入的字符，可用于密码输入等
* -t 指定超时时间，单位:秒
* -u 从文件描述符中读取输入
* -p 输出提示
* -a 读取到的数据存入到数组中，默认使用IFS变量指定的换行符
* -d 指定结束符，会一直读取直到读到该字符
* -i 给参数一个默认值
* -r 反斜杆字符不视为转义字符
* -k 指定预期的字符长度
* -n 用于从标准输入读取指定长度字符或者字节数，而不是读取整行输入

```shell
read -a array -p "please input 5 nums,split by blank:"
```

# readarray

从标准输入中读取多行输入，存入指定数组

* -d     指定每行的终结字符，而不是换行符
* -n     指定读取的最多行数
* -O    指定起始下标，默认是0
* -s     指定跳过的行数
* -t     移除末尾的分隔符，默认是换行符，配合-u命令使用
* -u    从文件描述符中读取数据
* -C    每读取指定行数就调用一次回调函数
* -c     指定调用回调函数的行数

```shell
readarray -t array <<< $(ifconfig |grep inet|grep -v inet6|awk -F' ' '{print $2}')
```

# mapfile
