//package aaa.admin.flipgame3commat3.data.utils
//
//import android.content.Context
//import com.appsflyer.AppsFlyerLib
//import com.onesignal.OSNotificationReceivedEvent
//import com.onesignal.OneSignal.OSRemoteNotificationReceivedHandler
//
//class Fiklikosrnrh : OSRemoteNotificationReceivedHandler {
//
//    override fun remoteNotificationReceived(p0: Context?, p1: OSNotificationReceivedEvent?) {
//        val fiklikonre = p1!!.notification.additionalData.get(Fikliku.FIKLIK).toString()
//        if (fiklikonre.isNotEmpty()) {
//            p0.let {
//                AppsFlyerLib.getInstance().logEvent(p0, fiklikonre, null)
//                p1.complete(null)
//            }
//        }
//    }
//}