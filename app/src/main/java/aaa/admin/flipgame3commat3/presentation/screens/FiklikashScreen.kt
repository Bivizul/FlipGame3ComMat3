package aaa.admin.flipgame3commat3.presentation.screens

import aaa.admin.flipgame3commat3.data.model.Fiklik
import aaa.admin.flipgame3commat3.data.utils.FiklikApi
import aaa.admin.flipgame3commat3.data.utils.Fikliku
import aaa.admin.flipgame3commat3.presentation.FiklikActivity
import aaa.admin.flipgame3commat3.presentation.navigation.Screen
import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//var fikliksec = 0

@Composable
fun FiklikashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val fiklikc = LocalContext.current as Activity


    LaunchedEffect(null) {
        CoroutineScope(Dispatchers.Main).launch {
//            if (Fikliku.getFiklikn(fiklikc) == Fikliku.FIKLIKD) fiklikcn(fiklikc, navController)
//            else fikliksuc(fiklikc, navController)
            fikliksuc(fiklikc, navController)
        }
    }
}

private fun fikliksuc(
    fiklikc: Activity,
    navController: NavHostController,
) {
    CoroutineScope(Dispatchers.Main).launch {
        val fiklikgr = FiklikApi().getFiklikg(
            Fiklik(
//                Fikliku.getFiklikj(fiklikc),
                Fikliku.getFiklikl(),
                Fikliku.getFiklikm(),
//                Fikliku.getFiklikf(fiklikc, fikliksec),
//                Fikliku.getFiklikn(fiklikc),
                Fikliku.getFikliks(fiklikc),
                Fikliku.getFiklikt(),
                Fikliku.getFikliki(fiklikc),
            )
        )
        if (fiklikgr.isSuccessful) {
            if (fiklikgr.body() != null) {
                fiklikgr.body()?.let { fiklikg ->
                    when (fiklikg.fiklikg) {
                        Fikliku.FIKLIKNP -> {
                            Fikliku.setFiklikosdp()
                            navController.navigate(Screen.FiklikHomeRoute.route)
                        }
                        Fikliku.FIKLIKG -> {
                            navController.navigate(Screen.FiklikHomeRoute.route)
                        }
                        else -> {
//                            Fikliku.setFiklikb(fiklikc)
//                            OneSignal.setExternalUserId(Fikliku.getGamflitpvi(fiklikg.fiklikg))
//                            AppsFlyerLib.getInstance()
//                                .setCustomerUserId(Fikliku.getGamflitpvi(fiklikg.fiklikg))
                            val fikliki = Intent(fiklikc, FiklikActivity::class.java)
                            fikliki.putExtra(Fikliku.FIKLIKKOR, fiklikg.fiklikg)
                            startActivity(fiklikc, fikliki, null)
                            fiklikc.finish()
                        }
                    }
                }
            } else {
                Fikliku.getFiklikdlg(fiklikc)
            }
        } else {
            Fikliku.getFiklikdlg(fiklikc)
        }
    }
}

//private fun fiklikcn(
//    fiklikc: Activity,
//    navController: NavHostController,
//) {
//    if (!Fikliku.getFiklikcb(fiklikc)) {
//        if (Fikliku.getFiklikafd(fiklikc) != Fikliku.FIKLIKEJ) {
//            val fiklikafd = JSONObject(Fikliku.getFiklikafd(fiklikc))
//            if (fiklikafd.get(Fikliku.FIKLIKFOS) == Fikliku.FIKLIKOV) {
//                Fikliku.setFiklikcb(fiklikc, fiklikafd.get(Fikliku.FIKLIKFOS) as String)
//                Fikliku.setFikliklu(fiklikafd)
//            } else if (fiklikafd.get(Fikliku.FIKLIKNOS).toString().isNotEmpty()) {
//                Fikliku.setFiklikcb(fiklikc, fiklikafd.get(Fikliku.FIKLIKNOS) as String)
//                Fikliku.setFikliklu(fiklikafd)
//            }
//        }
//        fikliksuc(fiklikc, navController)
//    } else {
//        fikliktimer(fiklikc, navController)
//    }
//}

//private fun fikliktimer(
//    fiklikc: Activity,
//    navController: NavHostController,
//) {
//    val fikliktimer = Timer()
//    fikliktimer.schedule(object : TimerTask() {
//        override fun run() {
//            if (Fikliku.getFiklikafd(fiklikc) != Fikliku.FIKLIKEJ) {
//                try {
//                    val fiklikafd = JSONObject(Fikliku.getFiklikafd(fiklikc))
//                    if (fiklikafd.get(Fikliku.FIKLIKFOS) == Fikliku.FIKLIKOV) {
//                        Fikliku.setFiklikcb(
//                            fiklikc,
//                            fiklikafd.get(Fikliku.FIKLIKFOS) as String
//                        )
//                        fikliktimer.cancel()
//                        fikliksuc(fiklikc, navController)
//                    } else if (fiklikafd.get(Fikliku.FIKLIKNOS).toString().isNotEmpty()) {
//                        Fikliku.setFiklikcb(
//                            fiklikc,
//                            fiklikafd.get(Fikliku.FIKLIKNOS) as String
//                        )
//                        fikliktimer.cancel()
//                        fikliksuc(fiklikc, navController)
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    fikliktimer.cancel()
//                    fikliksuc(fiklikc, navController)
//                }
//            }
//            fikliksec++
//            if (fikliksec == 10) {
//                fikliktimer.cancel()
//                fikliksuc(fiklikc, navController)
//            }
//        }
//    }, 0, 1000)
//}

