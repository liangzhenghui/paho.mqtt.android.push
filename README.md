# 项目源码是从eclipse 的paho.mqtt.android项目下载下来改造的。
# 项目结构
- org.eclipse.paho.android.service 是项目依赖核心
- org.eclipse.paho.android.sample 是paho.mqtt.android自带的demo示例
- paho.mqtt.android.example 是我改造的例子,主要添加了通知信息推送提示。

# 保活关键代码 
- BootstrapService

# 如何测试？
可以参照这篇文章安装mosquitto windows客户端
https://blog.csdn.net/wolinghuanyun/article/details/53492189
安装的时候遇到的几个错误,缺少ddl文件全部在这里
https://pan.baidu.com/s/1Ij9ektRm5QlQPkJTLNeqRw可以下载，下载后覆盖就行。
运行起来APP之后
给主题 exampleAndroid 推送信息
``
D:\liangzhenghui\mqtt\mosquitto-window\mosquitto>mosquitto_pub -t exampleAndroid
Topic -m 1234

``
搞掂!
# java 服务端客户端调用测试项目
https://github.com/liangzhenghui/mosquittodemo.git

# 未解决问题

- 在测试魅蓝的时候，发现在后台任务栏划掉当前的app,后台保活service会被干掉,我只能在魅蓝里面设置
后台管理->运行后台运行。

- 在测试华为机器的时候，发现应用要设置后台保护才能保活service。

- 以上2种机器都是要在机器上面设置了 应用后台保护才能实现保活service的目的。

这样的不太好,各位还有其他的方式吗？指教一下。
