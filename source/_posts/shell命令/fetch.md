---
title: fetch
categories:
	- git
	- git命令
---
# 更新同步远程分支情况

```shell
# 拉取所有的远程修改，不删除分支
git fetch
# 拉取指定的远程分支修改
git fetch origin/master
# 拉取远程分支，删除已经被删除的远程分支
git fetch -p/--prune
```
