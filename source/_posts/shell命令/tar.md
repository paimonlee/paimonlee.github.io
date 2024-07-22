---
title: tar
categories:
	- shell
	- shell命令
---
# tar

tar 命令用于将文件压缩,功能十分强大
基本使用方法如下

```shell
tar [OPTION...] [FILE]...
```

## 常用参数

* -c --create 创建一个新的压缩包
* -x --extract --get 释放压缩文件
* -z --gzip --gunzip --ungzip 指定为gzip格式
* -f --file 指定压缩的文件
* -C 解压文件到指定路径

# 示例

```shell
# 压缩文件夹
tar -czf file.tar.gz file/
# 压缩多个文件,指定为gzip格式
tar -czf files.tar.gz file1 file2
# 解压gzip压缩的文件
tar -zxf files.tar.gz -C files/
# 解压普通压缩文件
tar -xf files.tar.xz
```
