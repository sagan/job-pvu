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
===

* ReaderService: 通过IntentService启动读卡后台线程
* ReaderQueryReceiver.java: 监听UI发出的读卡请求事件，并调用ReaderService
* AndroidManifest.xml: 注册ReaderService和ReaderQueryReceiver


返回结果
===

目前直接通过Intent的setExtra返回basic结果，以后可以考虑返回通过json序列化的Object对象

所有键值前加ticket_前缀

* "type": "票卡类型"
* "num": "票卡卡号"
* "count": "票卡剩余次数"
* "passage_type": "进出站状态"
* "passage_station": "进出站车站"
* "amount": "票卡剩余金额"
* "deny_type": "拒付原因"
* "transaction_time": "交易时间"
* "sold_date": "发售日期"
* "subtype": "票种"
* "sold_station": "售票车站"
* "penalty_flag": "罚款标志"
* "penalty_station": "罚款车站"
* "status": "票卡状态"
* "card_type": "卡种"
* "sold_type": "票卡发售类型"
* "init_date": "票卡初始化日期"
* "memorial_flag": "纪念票标志"
* "test_flag": "测试票标志"
* "owner_identity_type": "卡主证件类型"
* "owner_identity_num": "卡主证件号码"
* "latest_transactions": "最近3次交易记录"
* "deny_flag": "阻止标志"
* "validation_date_start": "票卡启用日期"
* "validation_date_end": "票卡有效日期"
* "transaction_sequence_num": "交易序号"
* "physical_card_num": "卡片封面印刷编号"
* "init_sequence_num": "首次初始化批次流水号"
* "first_transaction_date": "首次交易日期"
* "analyze_result": "分析结果"
* "staff_num": "员工工号"
* "quota_daily_count": "每天允许乘坐的次数"
* "access_right_type": "乘坐权限类别"
* "current_day_used_count": "最近一天使用次数"
* "last_used_date": "最后使用日期"
* "blacklist_flag": "黑名单标志"

