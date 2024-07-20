---
title: 【Linux】安装字体.md
---
# 安装字体

1. 下载字体，以Jetbrains Mono为例
2. 解压字体文件
3. 拷贝字体文件到当前用户的tty目录
4. 使用命令安装文件

```shell
mkdir ~/.local/share/fonts/jetbrainsmono
cp ./* ~/.local/share/fonts/jetbrainsmono/
sudo mkfontscale
sudo mkfontdir
sudo fc-cache
```