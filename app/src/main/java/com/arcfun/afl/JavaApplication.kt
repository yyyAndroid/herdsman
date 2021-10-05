package com.arcfun.afl

import android.app.Application
import android.content.Context


class JavaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

//        val isMainProcess = TextUtils.equals(packageName, getCurrentProcessName)
//        if (!isMainProcess) {

//除了“主进程”，其他进程不需要进行数据上报、清理等逻辑。“主进程”通常为常驻进行，如果无常驻进程，即为UI进程。
//        }
//builder.setEnabled(ApmTask.FLAG_COLLECT_ACTIVITY_AOP); //activity采用aop方案时打开，默认关闭即可。
//builder.setEnabled(ApmTask.FLAG_LOCAL_DEBUG); //是否读取本地配置，默认关闭即可。

    }
}