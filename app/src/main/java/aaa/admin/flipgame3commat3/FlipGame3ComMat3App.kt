package aaa.admin.flipgame3commat3

import aaa.admin.flipgame3commat3.data.utils.Fikliku
import android.app.Application
import com.onesignal.OneSignal

class FlipGame3ComMat3App : Application() {

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(Fikliku.FIKLIKOS)
//        AppsFlyerLib.getInstance().init(Fikliku.FIKLIKAF, object :
//            AppsFlyerConversionListener {
//            override fun onConversionDataSuccess(p0: MutableMap<String, Any>?) {}
//            override fun onConversionDataFail(p0: String?) {}
//            override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {}
//            override fun onAttributionFailure(p0: String?) {}
//        }, this)
//        AppsFlyerLib.getInstance().start(this)
    }
}