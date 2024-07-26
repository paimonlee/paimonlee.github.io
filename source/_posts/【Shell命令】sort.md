sort命令是Unix系统强大的文件文本排序工具
## 基本用法
```shell
# 按照字母顺序排序file.txt的行，并输出到标准输出。
sort file.txt
# 按照字母顺序排序file.txt的行，并将结果保存到output.txt。
sort -o output.txt file.txt
```
## 常用选项
* n或-numeric-sort：根据字符串的数值部分进行排序。
* r或-reverse：逆序排序。
* k或-key=field1[,field2]：按照指定的字段或列进行排序。字段编号从1开始。
* t或-field-separator=char：指定字段分隔符，默认是空白字符（空格或制表符）。
* u或-unique：删除重复的行，只保留唯一的行。
* f或-ignore-case：在排序时忽略大小写。

