job-pvu
=======

目前通过Broadcast事件实现读卡器和App前台UI之间交互。（以后是否可以考虑一直在后台不断寻卡）

两个事件

* cn.panda.metro.android.psu.READER.query：监听到这个事件时，开始寻卡

* cn.panda.metro.android.psu.READER：通过这个事件将读卡结果返回给UI。读卡器超时或错误时也返回结果，并设置
错误标志位


读写器Service进程
===

1. 写一个读卡器类ReaderService继承IntentService

1. 在AndroidManifesto里添加几行监听"cn.panda.metro.android.psu.READER.query"事件


    <service android:name=".ReaderService"></service>
    <receiver android:name=".ReaderQueryReceiver">
    <intent-filter>
    <action android:name="cn.panda.metro.android.psu.READER.query" />
    </intent-filter>
    </receiver>

ReaderService请参考ReaderService.java里实例代码
