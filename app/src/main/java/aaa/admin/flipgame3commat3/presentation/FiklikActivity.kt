package aaa.admin.flipgame3commat3.presentation

import aaa.admin.flipgame3commat3.R
import aaa.admin.flipgame3commat3.data.utils.Fikliku
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.activity.ComponentActivity

@Suppress("DEPRECATION")
class FiklikActivity : ComponentActivity() {

    private lateinit var fiklikwv: WebView
    var fiklikfpc: ValueCallback<Array<Uri>>? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiklik)

        fiklikwv = findViewById(R.id.fiklikwv)
        fiklikwv.webViewClient = WebViewClient()

        fiklikwv.webChromeClient = MyChromeClient()
        fiklikwv.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        fiklikwv.isScrollbarFadingEnabled = false

        setSettings()

        val fiklikurl = intent.getStringExtra(Fikliku.FIKLIKKOR) ?: Fikliku.FIKLIKDOR

        if (savedInstanceState == null) {
            fiklikwv.post {
                kotlin.run { fiklikwv.loadUrl(fiklikurl) }
            }
        }

        fiklikwv.canGoBack()
        fiklikwv.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                fiklikwv.canGoBack()
            ) {
                fiklikwv.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setSettings() {
        val fiklikws = fiklikwv.settings
        fiklikws.javaScriptEnabled = true
        fiklikws.loadWithOverviewMode = true
        fiklikws.allowFileAccess = true
        fiklikws.domStorageEnabled = true
        fiklikws.builtInZoomControls = true
        fiklikws.displayZoomControls = false
        fiklikws.useWideViewPort = true
        fiklikws.setSupportZoom(true)
        fiklikws.userAgentString = fiklikws.userAgentString.replace("; wv", "")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        fiklikwv.saveState(outState)
    }

    inner class MyChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooserParams: FileChooserParams
        ): Boolean {
            fiklikfpc = filePath
            val fikliki = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            fikliki.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            startActivityForResult(fikliki, Fikliku.FIKLIKRC)
            return true
        }

        private var fiklikcv: View? = null
        private var fiklikcvc: CustomViewCallback? = null
        private var fiklikoo = 0
        private var fiklikosuv = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (fiklikcv == null) {
                null
            } else BitmapFactory.decodeResource(
                this@FiklikActivity.applicationContext.resources,
                2130837573
            )
        }

        override fun onHideCustomView() {
            (this@FiklikActivity.window.decorView as FrameLayout).removeView(fiklikcv)
            fiklikcv = null
            this@FiklikActivity.window.decorView.systemUiVisibility =
                fiklikosuv
            this@FiklikActivity.requestedOrientation = fiklikoo
            fiklikcvc!!.onCustomViewHidden()
            fiklikcvc = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?
        ) {
            if (fiklikcv != null) {
                onHideCustomView()
                return
            }
            fiklikcv = paramView
            fiklikosuv =
                this@FiklikActivity.window.decorView.systemUiVisibility
            fiklikoo = this@FiklikActivity.requestedOrientation!!
            fiklikcvc = paramCustomViewCallback
            (this@FiklikActivity.window.decorView as FrameLayout).addView(
                fiklikcv,
                FrameLayout.LayoutParams(-1, -1)
            )
            this@FiklikActivity.window.decorView.systemUiVisibility =
                3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == Fikliku.FIKLIKRC) {
            fiklikfpc!!.onReceiveValue(
                WebChromeClient.FileChooserParams.parseResult(
                    resultCode,
                    intent
                )
            )
            fiklikfpc = null
        }
    }

}