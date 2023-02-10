package aaa.admin.flipgame3commat3.data.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.telephony.TelephonyManager
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage
import com.onesignal.OneSignal
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
object Fikliku {

    private const val FIKLIKM = "Please reload game"
    private const val FIKLIKK = "fiklikk"
    private const val NOFIKLIK = "nofiklik"
    private const val FIKLIKIV = "http://65.109.10.118/games/FlipGame3ComMat3/olj.jpg"
    private const val FIKLIKGMT = "GMT"
    private const val FIKLIKPB = "Exit"

    //    private const val AFPREFFIKLIK = "appsflyer-data"
//    private const val FIKLIKAI = "attributionId"
    private const val FIKLIKIH = "http://65.109.10.118/games/FlipGame3ComMat3/wmo.jpg"
    private const val FIKLIKT = "Oops, error connection with game network"

    //    const val FIKLIKFOS = "af_status"
//    const val FIKLIKAF = "VdkuAEYGy3tZxMUc6xgshQ"
    const val FIKLIKRC = 100
    const val FIKLIKDOR = "https://www.google.com/"
    const val FIKLIKOS = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
    const val FIKLIKD = "default"
    const val FIKLIKKOR = "fiklikkor"

    //    const val FIKLIKNOS = "campaign"
//    const val FIKLIKOV = "Organic"
    const val FIKLIKNP = "nopush"

    //    const val FIKLIK = "fiklik"
//    const val FIKLIKFL = "fiklikfl"
//    const val FIKLIKEJ = "[]"
    const val APPPREFFIKLIK = "apppreffiklik"
    const val FIKLIKG = "fiklikg"

//    fun setFiklikb(fiklikc: Context) {
//        val fikliksp =
//            fiklikc.getSharedPreferences(APPPREFFIKLIK, Context.MODE_PRIVATE)
//        fikliksp.edit().putBoolean(FIKLIKFL, false).apply()
//    }

    fun getFiklikdlg(fiklikact: Activity) {
        AlertDialog.Builder(fiklikact).apply {
            setTitle(FIKLIKT)
            setMessage(FIKLIKM)
            setPositiveButton(FIKLIKPB) { _, _ ->
                fiklikact.finish()
                System.exit(0)
            }
            setCancelable(true)
        }.create().show()
    }

    @Composable
    fun Fiklikimg() {
        val fiklikc = LocalConfiguration.current.orientation
        val fikliki = when (fiklikc) {
            Configuration.ORIENTATION_PORTRAIT -> FIKLIKIV
            else -> FIKLIKIH
        }
        AsyncImage(
            model = fikliki,
            contentDescription = "image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }

//    fun getGamflitpvi(noofits: String): String {
//        val noofitmin = noofits.indexOf("view_id=") + 8
//        val noofitmax = noofits.indexOf("&stream")
//        return noofits.substring(noofitmin, noofitmax)
//    }

    fun setFiklikosdp() = OneSignal.disablePush(true)

    fun getFiklikt(): String {
        val fikliktz: String = SimpleDateFormat("z", Locale.getDefault()).format(
            Calendar.getInstance(
                TimeZone.getTimeZone(FIKLIKGMT), Locale.getDefault()
            ).time
        ).replace(FIKLIKGMT, "")
        val fiklikzone = if (fikliktz.contains(":")) fikliktz else FIKLIKD
        return fiklikzone
    }

    fun getFikliki(fiklikc: Context): String {
        val fikliksp = fiklikc.getSharedPreferences(APPPREFFIKLIK, Context.MODE_PRIVATE)
        var fiklikid = fikliksp.getString(FIKLIKK, NOFIKLIK) ?: NOFIKLIK
        if (fiklikid == NOFIKLIK) {
            val fiklikd = Date()
            val fikliksdf = SimpleDateFormat("yyMMddhhmmssMs")
            val fiklikdt = fikliksdf.format(fiklikd)
            val fiklikrn = (10000 until 100000).random()
            fiklikid = fiklikdt + fiklikrn
            fikliksp.edit().putString(FIKLIKK, fiklikid).apply()
        }
        return fiklikid
    }

//    fun getFiklikafd(fiklikc: Context): String {
//        val fiklikafsp =
//            fiklikc.getSharedPreferences(AFPREFFIKLIK, Context.MODE_PRIVATE)
//        return fiklikafsp.getString(FIKLIKAI, FIKLIKEJ) ?: FIKLIKEJ
//    }


    fun getFiklikl() = Locale.getDefault().language


//    fun setFiklikcb(fiklikc: Context, fikliks: String) {
//        val fiklikafsp =
//            fiklikc.getSharedPreferences(AFPREFFIKLIK, Context.MODE_PRIVATE)
//        fiklikafsp.edit().putString(FIKLIK, fikliks).apply()
//    }
//
//    fun getFiklikcb(fiklikc: Context): Boolean {
//        val fiklikafsp =
//            fiklikc.getSharedPreferences(AFPREFFIKLIK, Context.MODE_PRIVATE)
//        return fiklikafsp.getBoolean(FIKLIKFL, true)
//    }
//
//    fun setFikliklu(fiklikjo: JSONObject) {
//        CoroutineScope(Dispatchers.IO).launch {
//            FiklikApi().setFiklikr(
//                fiklikjo
//            )
//        }
//    }

    fun getFikliks(fiklikc: Context) =
        (fiklikc.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager).simCountryIso

//    fun getFiklikj(fiklikc: Context): JSONObject {
//        val fikliksp =
//            fiklikc.getSharedPreferences(AFPREFFIKLIK, Context.MODE_PRIVATE)
//        val fiklikd = fikliksp.getString(FIKLIKAI, FIKLIKEJ) ?: FIKLIKEJ
//        return try {
//            JSONObject(fiklikd)
//        } catch (e: Exception) {
//            JSONObject()
//        }
//    }

//    fun getFiklikn(fiklikc: Context): String {
//        val fikliksp =
//            fiklikc.getSharedPreferences(APPPREFFIKLIK, Context.MODE_PRIVATE)
//        return fikliksp.getString(FIKLIK, FIKLIKD) ?: FIKLIKD
//    }

    fun getFiklikm() = "${android.os.Build.MANUFACTURER} ${android.os.Build.MODEL}"

//    @SuppressLint("MissingPermission")
//    fun getFikliknet(fiklikc: Context): Boolean {
//        val conmanfiklik =
//            fiklikc.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val netinffiklik = conmanfiklik.activeNetworkInfo
//        return netinffiklik != null && netinffiklik.isConnected
//    }
//
//    fun getFiklikf(fiklikc: Context, fikliksec: Int): Int {
//        val fikliksp =
//            fiklikc.getSharedPreferences(AFPREFFIKLIK, Context.MODE_PRIVATE)
//        return if (fikliksp.getBoolean(FIKLIKFL, true)) fikliksec else -1
//    }

}