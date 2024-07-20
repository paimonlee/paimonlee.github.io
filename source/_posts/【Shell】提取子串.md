---
title: 【Shell】提取子串.md
---
# shell脚本提取字串

## grep

### 参数
```shell
-o, --only-matching       仅展示每行被匹配中的数据
```
使用-o参数可以只显示匹配中的数据

### 示例
```shell
ps -ef|grep -Eo 'httpPort=[0-9]+'|awk -F'=' '{print $2}'
```
提取出程序运行的参数port