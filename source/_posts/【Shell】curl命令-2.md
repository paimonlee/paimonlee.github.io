# 三、Linux curl命令退出码

下面是linux curl命令的错误代码和她们的相应的错误消息，可能会出现在恶劣的环境。

| 退出码 | 错误描述                                                                                                                                                                                                 |
| ------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1      | Unsupported protocol. This build of curl has no support for this protocol.                                                                                                                               |
| 2      | Failed to initialize.                                                                                                                                                                                    |
| 3      | URL malformed. The syntax was not correct.                                                                                                                                                               |
| 5      | Couldn't resolve proxy. The given proxy host could not be resolved.                                                                                                                                      |
| 6      | Couldn't resolve host. The given remote host was not resolved.                                                                                                                                           |
| 7      | Failed to connect to host.                                                                                                                                                                               |
| 8      | FTP weird server reply. The server sent data curl couldn't parse.                                                                                                                                        |
| 9      | FTP access denied. The server denied login or denied access to the particular resource or directory you wanted to reach. Most often you tried to change to a directory that doesn't exist on the server. |
| 11     | FTP weird PASS reply. Curl couldn't parse the reply sent to the PASS request.                                                                                                                            |
| 13     | FTP weird PASV reply, Curl couldn't parse the reply sent to the PASV request.                                                                                                                            |
| 14     | FTP weird 227 format. Curl couldn't parse the 227-line the server sent.                                                                                                                                  |
| 15     | FTP can't get host. Couldn't resolve the host IP we got in the 227-line.                                                                                                                                 |
| 17     | FTP couldn't set binary. Couldn't change transfer method to binary.                                                                                                                                      |
| 18     | Partial file. Only a part of the file was transferred.                                                                                                                                                   |
| 19     | FTP couldn't download/access the given file, the RETR (or similar) command failed.                                                                                                                       |
| 21     | FTP quote error. A quote command returned error from the server.                                                                                                                                         |
| 22     | HTTP page not retrieved. The requested url was not found or returned another error with the HTTP error code being 400 or above. This return code only appears if -f/--fail is used.                      |
| 23     | Write error. Curl couldn't write data to a local filesystem or similar.                                                                                                                                  |
| 25     | FTP couldn't STOR file. The server denied the STOR operation, used for FTP uploading.                                                                                                                    |
| 26     | Read error. Various reading problems.                                                                                                                                                                    |
| 27     | Out of memory. A memory allocation request failed.                                                                                                                                                       |
| 28     | Operation timeout. The specified time-out period was reached according to the conditions.                                                                                                                |
| 30     | FTP PORT failed. The PORT command failed. Not all FTP servers support the PORT command, try doing a transfer using PASV instead!                                                                         |
| 31     | FTP couldn't use REST. The REST command failed. This command is used for resumed FTP transfers.                                                                                                          |
| 33     | HTTP range error. The range "command" didn't work.                                                                                                                                                       |
| 34     | HTTP post error. Internal post-request generation error.                                                                                                                                                 |
| 35     | SSL connect error. The SSL handshaking failed.                                                                                                                                                           |
| 36     | FTP bad download resume. Couldn't continue an earlier aborted download.                                                                                                                                  |
| 37     | FILE couldn't read file. Failed to open the file. Permissions?                                                                                                                                           |
| 38     | LDAP cannot bind. LDAP bind operation failed.                                                                                                                                                            |
| 39     | LDAP search failed.                                                                                                                                                                                      |
| 41     | Function not found. A required LDAP function was not found.                                                                                                                                              |
| 42     | Aborted by callback. An application told curl to abort the operation.                                                                                                                                    |
| 43     | Internal error. A function was called with a bad parameter.                                                                                                                                              |
| 45     | Interface error. A specified outgoing interface could not be used.                                                                                                                                       |
| 47     | Too many redirects. When following redirects, curl hit the maximum amount.                                                                                                                               |
| 48     | Unknown TELNET option specified.                                                                                                                                                                         |
| 49     | Malformed telnet option.                                                                                                                                                                                 |
| 51     | The peer's SSL certificate or SSH MD5 fingerprint was not ok.                                                                                                                                            |
| 52     | The server didn't reply anything, which here is considered an error.                                                                                                                                     |
| 53     | SSL crypto engine not found.                                                                                                                                                                             |
| 54     | Cannot set SSL crypto engine as default.                                                                                                                                                                 |
| 55     | Failed sending network data.                                                                                                                                                                             |
| 56     | Failure in receiving network data.                                                                                                                                                                       |
| 58     | Problem with the local certificate.                                                                                                                                                                      |
| 59     | Couldn't use specified SSL cipher.                                                                                                                                                                       |
| 60     | Peer certificate cannot be authenticated with known CA certificates.                                                                                                                                     |
| 61     | Unrecognized transfer encoding.                                                                                                                                                                          |
| 62     | Invalid LDAP URL.                                                                                                                                                                                        |
| 63     | Maximum file size exceeded.                                                                                                                                                                              |
| 64     | Requested FTP SSL level failed.                                                                                                                                                                          |
| 65     | Sending the data requires a rewind that failed.                                                                                                                                                          |
| 66     | Failed to initialize SSL Engine.                                                                                                                                                                         |
| 67     | The user name, password, or similar was not accepted and curl failed to log in.                                                                                                                          |
| 68     | File not found on TFTP server.                                                                                                                                                                           |
| 69     | Permission problem on TFTP server.                                                                                                                                                                       |
| 70     | Out of disk space on TFTP server.                                                                                                                                                                        |
| 71     | Illegal TFTP operation.                                                                                                                                                                                  |
| 72     | Unknown TFTP transfer ID.                                                                                                                                                                                |
| 73     | File already exists (TFTP).                                                                                                                                                                              |
| 74     | No such user (TFTP).                                                                                                                                                                                     |
| 75     | Character conversion failed.                                                                                                                                                                             |
| 76     | Character conversion functions required.                                                                                                                                                                 |
| 77     | Problem with reading the SSL CA cert (path? access rights?).                                                                                                                                             |
| 78     | The resource referenced in the URL does not exist.                                                                                                                                                       |
| 79     | An unspecified error occurred during the SSH session.                                                                                                                                                    |
| 80     | Failed to shut down the SSL connection.                                                                                                                                                                  |
| 82     | Could not load CRL file, missing or wrong format (added in 7.19.0).                                                                                                                                      |
| 83     | Issuer check failed (added in 7.19.0).                                                                                                                                                                   |
| XX     | More error codes will appear here in future releases. The existing ones are meant to never change.                                                                                                       |

# 四、常见用法

### 1、下载(option:-o或者option:-O)

1.1、下载页面：

curl -o dodo1.jpg http:www.linux.com/dodo1.JPG
#要注意-O这里后面的url要具体到某个文件，不然抓不下来
curl -O http://www.linux.com/dodo1.JPG

1.2：循环下载
有时候下载图片可以能是前面的部分名称是一样的，就最后的尾椎名不一样。这样就会把dodo1，dodo2，dodo3，dodo4，dodo5全部保存下来
curl -O http://www.linux.com/dodo[1-5].JPG

1.3：下载重命名
在hello/dodo1.JPG的文件下载下来就会变成hello_dodo1.JPG,其他文件依此类推，从而有效的避免了文件被覆盖
curl -o #1_#2.JPG http://www.linux.com/{hello,bb}/dodo[1-5].JPG

由于下载的hello与bb中的文件名都是dodo1，dodo2，dodo3，dodo4，dodo5。因此第二次下载的会把第一次下载的覆盖，这样就需要对文件进行重命名。
curl -O http://www.linux.com/{hello,bb}/dodo[1-5].JPG

1.4：分块下载(option：-r)
curl -r 0-100 -o dodo1_part1.JPG http://www.linux.com/dodo1.JPG
curl -r 100-200 -o dodo1_part2.JPG http://www.linux.com/dodo1.JPG
curl -r 200- -o dodo1_part3.JPG http://www.linux.com/dodo1.JPG
cat dodo1_part* > dodo1.JPG  #这样就可以查看dodo1.JPG的内容了

1.5：通过ftp下载文件(option：-u)
curl可以通过ftp下载文件，curl提供两种从ftp中下载的语法
curl -O -u 用户名:密码 ftp://www.linux.com/dodo1.JPG
curl -O ftp://用户名:密码@www.linux.com/dodo1.JPG

1.6:下载，显示进度条(option：-#)或不显示进度条(option：-s)
curl -# -O http://www.linux.com/dodo1.JPG
curl -s -O http://www.linux.com/dodo1.JPG

1.7、下载，断点续传(-C `<offset>`)
断点续转，从文件头的指定位置开始继续下载/上传；offset续传开始的位置，如果offset值为“-”，curl会自动从文件中识别起始位置开始传输；
curl -# -o centos6.8.iso -C - http://mirrors.aliyun.com/centos/6.8/isos/x86_64/CentOS-6.8-x86_64-minimal.iso
curl -C -O http://www.linux.com/dodo1.JPG

## 2、上传文件(option:-T)

curl -T dodo1.JPG -u 用户名:密码 ftp://www.linux.com/img/

## 3、伪造来源页面|伪造referer|盗链 (option：-e)

很多服务器会检查http访问的referer从而来控制访问。比如：你是先访问首页，然后再访问首页中的邮箱页面，这里访问邮箱的referer地址就是访问首页成功后的页面地址，如果服务器发现对邮箱页面访问的referer地址不是首页的地址，就断定那是个盗连了
#这样就会让服务器其以为你是从www.linux.com点击某个链接过来的
curl -e "www.linux.com" http://mail.linux.com
#告诉爱E族，我是从百度来的
curl -e http://baidu.com http://aiezu.com

## 4、伪造代理设备(模仿浏览器)

有些网站需要使用特定的浏览器去访问他们，有些还需要使用某些特定的版本。curl内置option:-A可以让我们指定浏览器去访问网站
curl -A "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.0)" http://www.linux.com
#告诉爱E族，我是GOOGLE爬虫蜘蛛（其实我是curl命令）
curl -A " Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)" http://aiezu.com
#告诉爱E族，我用的是微信内置浏览器
curl -A "Mozilla/5.0 AppleWebKit/600 Mobile MicroMessenger/6.0" http://aiezu.com

## 5、设置http请求

5.1、设置http请求头(或option:-H或option:--head)
curl -H "Cache-Control:no-cache"  http://aiezu.com

5.2、指定proxy服务器以及其端口(option::-x)
#很多时候上网需要用到代理服务器(比如是使用代理服务器上网或者因为使用curl别人网站而被别人屏蔽IP地址的时候)，幸运的是curl通过使用内置option：-x来支持设置代理
curl -x 192.168.100.100:1080 http://www.linux.com

## 6、http响应头

6.1、查看http响应头(option:-I)

看看本站的http头是怎么样的

curl -I  http://aiezu.com
输出：
HTTP/1.1 200 OK
Date: Fri, 25 Nov 2016 16:45:49 GMT
Server: Apache
Set-Cookie: rox__Session=abdrt8vesprhnpc3f63p1df7j4; path=/
Expires: Thu, 19 Nov 1981 08:52:00 GMT
Cache-Control: no-store, no-cache, must-revalidate, post-check=0, pre-check=0
Pragma: no-cache
Vary: Accept-Encoding
Content-Type: text/html; charset=utf-8

6.2、保存http的response里面的header信息(option:-D)
curl -D cookied.txt http://www.linux.com
执行后cookie信息就被存到了cookied.txt里面了
注意：-c(小写)产生的cookie和-D里面的cookie是不一样的。

## 7、发送表单数据

curl -F "pic=@logo.png" -F "site=aiezu"  http://aiezu.com/

## 8、cookie

8.1、发送cookie(option:-b）
#有些网站是使用cookie来记录session信息。对于chrome这样的浏览器，可以轻易处理cookie信息，但在curl中只要增加相关参数也是可以很容易的处理cookie
curl -b "domain=aiezu.com"  http://aiezu.com
#很多网站都是通过监视你的cookie信息来判断你是否按规矩访问他们的网站的，因此我们需要使用保存的cookie信息。内置option: -b
curl -b cookiec.txt http://www.linux.com

8.2、保存http的response里面的cookie信息(option:-c）
执行后http的response里面的cookie信息就被存到了cookiec.txt里面了
curl -c cookiec.txt  http://www.linux.com

## 9、测试一个网址

9.1、测试一个网址是否可达
curl -v http://www.linux.com

9.2、测试网页返回值(option:-w [format])
curl -o /dev/null -s -w %{http_code} www.linux.com

## 10、保存访问的网页(>>)

2.1:使用linux的重定向功能保存
curl http://www.linux.com >> linux.html

## 11、请求方式

curl -i -v -H '' -X POST -d '' http:www.test.com/a/b
其中，-X POST -d, -X GET -d, -X PUT -d 分别等价于-F, -G -d, -P

以post请求为例：
11.1、 -X POST -d
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