---
title: curl命令示例
categories:
	- shell
	- shell命令
---
### 1、下载

```shell
# 要注意-O这里后面的url要具体到某个文件，不然抓不下来
# 指定输出文件名
curl -o dodo1.jpg http:www.linux.com/dodo1.JPG
# 不指定输出名
curl -O http://www.linux.com/dodo1.JPG
# 正则下载多个文件
curl -O http://www.linux.com/dodo[1-5].JPG

# 下载多个文件重命名避免被覆盖
curl -o #1_#2.JPG http://www.linux.com/{hello,bb}/dodo[1-5].JPG

# 分块下载
curl -r 0-100 -o dodo1_part1.JPG http://www.linux.com/dodo1.JPG
curl -r 100-200 -o dodo1_part2.JPG http://www.linux.com/dodo1.JPG
curl -r 200- -o dodo1_part3.JPG http://www.linux.com/dodo1.JPG
cat dodo1_part* > dodo1.JPG  #这样就可以查看dodo1.JPG的内容了

# 通过ftp下载文件,curl提供两种从ftp中下载的语法
curl -O -u 用户名:密码 ftp://www.linux.com/dodo1.JPG
curl -O ftp://用户名:密码@www.linux.com/dodo1.JPG

# 下载，显示进度条(option：-#)或不显示进度条(option：-s)
curl -# -O http://www.linux.com/dodo1.JPG
curl -s -O http://www.linux.com/dodo1.JPG

# 断点续传(-C `<offset>`),从文件头的指定位置开始继续下载/上传；offset续传开始的位置，如果offset值为“-”，curl会自动从文件中识别起始位置开始传输；
curl -# -o centos6.8.iso -C - http://mirrors.aliyun.com/centos/6.8/isos/x86_64/CentOS-6.8-x86_64-minimal.iso
curl -C -O http://www.linux.com/dodo1.JPG
```

## 2、上传文件

```shell
curl -T dodo1.JPG -u 用户名:密码 ftp://www.linux.com/img/
```

## 3、伪造来源页面|伪造referer|盗链 (option：-e)

很多服务器会检查http访问的referer从而来控制访问。
比如：
先访问首页，然后再访问首页中的邮箱页面，这里访问邮箱的referer地址就是访问首页成功后的页面地址，
如果服务器发现对邮箱页面访问的referer地址不是首页的地址，就断定那是个盗连了
```shell
#伪造为www.linux.com点击某个链接过来的
curl -e "www.linux.com" http://mail.linux.com
```

## 4、伪造代理设备(模仿浏览器)

有些网站需要使用特定的浏览器去访问他们，有些还需要使用某些特定的版本。curl内置option:-A可以让我们指定浏览器去访问网站
```shell
curl -A "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.0)" http://www.linux.com
```

## 5、设置http请求头

```shell
设置http请求头(或option:-H或option:--head)
curl -H "Cache-Control:no-cache"  http://aiezu.com
```

## 6、设置代理
```shell
# 指定proxy服务器以及其端口(option::-x)
# 很多时候上网需要用到代理服务器(比如是使用代理服务器上网或者因为使用curl别人网站而被别人屏蔽IP地址的时候)，
# 幸运的是curl通过使用内置option：-x来支持设置代理
curl -x 192.168.100.100:1080 http://www.linux.com
```

## 7、http响应头

### 查看http响应头(option:-I)
```shell
curl -I  http://www.baidu.com
```

```
HTTP/1.1 200 OK
Date: Fri, 25 Nov 2016 16:45:49 GMT
Server: Apache
Set-Cookie: rox__Session=abdrt8vesprhnpc3f63p1df7j4; path=/
Expires: Thu, 19 Nov 1981 08:52:00 GMT
Cache-Control: no-store, no-cache, must-revalidate, post-check=0, pre-check=0
Pragma: no-cache
Vary: Accept-Encoding
Content-Type: text/html; charset=utf-8

```

### 保存http的response里面的header信息(option:-D)
```shell
# 执行后cookie信息就被存到了cookied.txt里面了
curl -D cookied.txt http://www.linux.com
```
注意：-c(小写)产生的cookie和-D里面的cookie是不一样的。

## 8、发送表单数据

```shell
curl -F "pic=@logo.png" -F "site=aiezu"  http://www.baidu.com/
```

## 9、cookie

### 发送cookie(option:-b）
```
# 指定单条cookie
curl -b "user=admin"  http://www.linux.com
# 指定文件
curl -b cookiec.txt http://www.linux.com
```

### 保存http的response里面的cookie信息(option:-c）
执行后http的response里面的cookie信息就被存到了cookiec.txt里面了
```shell
curl -c cookiec.txt  http://www.linux.com
```

## 10、测试网址

```
# 测试一个网址是否可达
curl -v http://www.linux.com

# 测试网页返回值(option:-w [format])
curl -o /dev/null -s -w %{http_code} www.linux.com
```

## 11、请求方式

curl -i -v -H '' -X POST -d '' http:www.test.com/a/b
其中，-X POST -d, -X GET -d, -X PUT -d 分别等价于-F, -G -d, -P

以post请求为例：
 -X POST -d
(11.1.1)、POST application/x-www-form-urlencoded
application/x-www-form-urlencoded是默认的
curl -X POST -d "param1=value1¶m2=value2" http://localhost:3000/data
等价于
curl -H "Content-Type:application/x-www-form-urlencoded" -X POST -d "param1=value1¶m2=value2" http://localhost:3000/data
使用数据文件
curl -X POST -d "@data.txt" http://localhost:3000/data
其中data.txt内容如下：param1=value1¶m2=value2

(11.1.2)、POST application/json
curl -H "Content-Type:application/json" -X POST -d '{"key1":"value1","key2":"value2"}' http://localhost:3000/data
使用数据文件的话：
curl -X POST -d "@data.json" http://localhost:3000/data
其中data.json内容如下：{"key1":"value1","key2":"value2"}
再举个例子：
curl -H "Content-type:application/json" -X POST -d "{\"app_key\":\"$appKey\",\"time_stamp\":\"$time\"}" http://www.test.com.cn/a/b

11.2、-F
curl  -v -H "token: 222" -F "file=@/Users/fungleo/Downloads/401.png" localhost:8000/api/v1/upimg

curl -f http://www.linux.com/error

11.3、其它举例

(11.3.1)、

curl  -X POST "http://www.test.com/e/f" -H "Content-Type:application/x-www-form-urlencoded;charset=UTF-8"
-d "a=b"
-d "c=d"
-d "e=f"
-d "g=h"

(11.3.2)、错误：curl -i -G -d "a=b#1&c=d" http://www.test.com/e/f
正确：要把参数值是特殊符号的用urlencode转换过来
curl -i -G -d "a=b%231&c=d" http://www.test.com/e/f

## 12、调试

curl -v可以显示一次http通信的整个过程，包括端口连接和http request头信息。
如果觉得还不够，那么下面的命令可以查看更详细的通信过程：
curl --trace output.txt www.baidu.com 或者 curl --trace-ascii output.txt www.baidu.com
运行后，请打开output.txt文件查看。
curl --trace output.txt  http://www.baidu.com
curl --trace-ascii output2.txt  http://www.baidu.com
curl --trace output3.txt --trace-time http://www.baidu.com
curl --trace-ascii output4.txt --trace-time http://www.baidu.com

![](https://img-blog.csdnimg.cn/20190605132404348.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d1aHVhZ3Vfd3VodWFndW8=,size_16,color_FFFFFF,t_70)

![](https://img-blog.csdnimg.cn/20190605132434969.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d1aHVhZ3Vfd3VodWFndW8=,size_16,color_FFFFFF,t_70)

举例:有需求每5分钟请求一次http://www.test.com/a/b生成一个日志文件。希望一月的日志(正确的和错误的)能写入一个日志文件
day=`date +%F`
logfile='/var/logs/www.test.com_'`date +%Y%m`'.log'
/usr/bin/echo -e "\n\n[${day}] Start request \n " >> ${logfile}
/bin/curl -v "http://www.test.com/a/b" -d "ccccc" 1>> ${logfile} 2>> ${logfile} --trace-time
/usr/bin/echo -e "\n\n[${day}] End request\n" >> ${logfile}

## 13、显示抓取错误

curl -f http://www.linux.com/error
