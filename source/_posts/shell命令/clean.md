---
title: clean
categories:
	- git
	- git命令
---
# 介绍

clean从工作树中删除未跟踪的文件

```shell
git clean [-d] [-f] [-i] [-n] [-q] [-e <pattern>] [-x | -X] [--] [<pathspec>...]
```

# 参数解析

```
-d        Normally, when no <pathspec> is specified, git clean will not recurse into untracked directories to avoid removing too much. Specify -d to have it recurse into such directories as well. If a <pathspec> is specified, -d is
           irrelevant; all untracked files matching the specified paths (with exceptions for nested git directories mentioned under --force) will be removed.

-f, --force	   	强制删除文件

-i, --interactive  	显示所有删除的文件（交互模式）

-n, --dry-run 	   	不去删除文件，只显示会删除的文件

-q, --quiet		静默模式

-e <pattern>, --exclude=<pattern>	正则表达式进行排除文件
           Use the given exclude pattern in addition to the standard ignore rules (see gitignore(5)).

-x			不使用gitignore中的忽略模式，只使用-e指定的模式排除文件
```
