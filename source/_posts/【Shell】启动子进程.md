source 和 . 不启用新的shell，在当前shell中执行，设定的局部变量在执行完命令后仍然有效。

bash 或 sh 或 shell script 执行时，另起一个子shell，其继承父shell的环境变量，其子shell的变量执行完后不影响父shell。

exec是用被执行的命令行替换掉当前的shell进程，且exec命令后的其他命令将**不再执行**。