# 隐藏指定文件
一般情况下，暂时隐藏修改的命令是
```shell
# 使用上一个commit的信息
git stash
# 使用指定信息
git stash -m "This is a message"
```

git stash支持隐藏指定文件，在隐藏指定文件时，不能省略push参数，必须使用完整的命令
```shell
git stash push **/*.java
git stash push -m "This is a message" **/*.java
```

# 使用指定的隐藏记录
一般情况下使用指定的隐藏记录命令是
```shell
git stash pop [index]
```

在没有冲突的情况下，这个命令会把隐藏给删除。
如果不希望隐藏记录消失，可以使用命令
```shell
git stash apply [index]
```