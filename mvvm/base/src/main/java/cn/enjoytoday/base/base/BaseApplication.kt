package cn.enjoytoday.base.base

import android.app.Application
import android.content.Context
import cn.enjoytoday.base.BuildConfig
import cn.enjoytoday.base.utils.SPUtils
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Application基类
 */
open class BaseApplication:Application() {

    lateinit var context:Context

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext
        initARouter()
        SPUtils.init(context,Common.APP_SP_NAME)
    }


    private fun initARouter(){
        if (BuildConfig.DEBUG) {   // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog()    // 打印日志
            ARouter.openDebug()  // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this)// 尽可能早，推荐在Application中初始化
    }




}