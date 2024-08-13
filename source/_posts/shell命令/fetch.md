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

# 获取远程分支


## 1、git checkout target-branch

```

# 获取远程所有分支
git fetch
# 查看所有远程分支，找到需要的远程分支，例如 origin/targetbranch
git branch -r
# 在本地新建一个同名分支，然后系统会自动与该远程分支关联
git checkout targetbranch
# 注意（git checkout origin/mybranch 会进入detached head状态，不会在本地新建分支，不要这样写））
```


## 2、git checkout -b 本地分支名 origin/远程分支名

```
# 首先，获取远程所有分支
git fetch
# 创建与远程分支关联的本地分支（可以同名，也可以不同名；建议同名，方便管理）
git checkout -b 本地分支名 origin/远程分支名
```

## 3、git checkout --track origin/远程分支名

```
# 首先，获取远程所有分支
git fetch
# 创建与远程分支关联的本地分支
git checkout --track origin/远程分支名
```

## 4、git checkout -t origin/远程分支名

```
# 首先，获取远程所有分支
git fetch
# 创建与远程分支关联的本地分支
git checkout -t origin/远程分支名
```

## 5、git fetch [repo] [remote_branch_name]:[local_branch_name]

```
# 获取远程指定分支，并创建与之关联的本地分支
git fetch [repo] [remote_branch_name]:[local_branch_name]  
# 举例：git fetch origin TargetBranch:tempBranch  
# 从远程仓orgin仓的TargetBranch分支下载到本地，并新建一个tempBranch分支
# [remote_branch_name]:[local_branch_name] 可同名，也可不同名；建议同名，便于管理
# 切换当前分支为本地建立的分支
git checkout [local_branch_name]
```
