job-pvu
=======

目前通过Broadcast事件实现读卡器和App前台UI之间交互。（以后是否可以考虑一直在后台不断寻卡）

建议在开发阶段将读卡器代码创建单独的App（不需要任何UI，只有一个自动运行的后台Service）。
正式发布时可以将轻易将两部分代码合并到一个App中。

事件

* cn.panda.metro.android.psu.READER.query：UI发出。监听到这个事件时，开始寻卡

* cn.panda.metro.android.psu.READER：通过这个事件将读卡结果返回给UI。读卡器超时或错误时也返回结果，并设置
错误标志位


读写器Service进程
===

文件

* ReaderService: 通过IntentService启动读卡后台线程
* ReaderQueryReceiver.java: 监听UI发出的读卡请求事件，并调用ReaderService
* AndroidManifest.xml: 注册ReaderService和ReaderQueryReceiver

