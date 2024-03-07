package com.flourish.sdk.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.flourish.sdk.android.databinding.RewardsMainBinding
import com.flourish.sdk.android.webview.JSBridge

class RewardsActivity : AppCompatActivity() {

    private lateinit var binding: RewardsMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RewardsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val token = Flourish.token
        val language = Flourish.language.value
        binding.flourishApp.settings.javaScriptEnabled = true
        binding.flourishApp.addJavascriptInterface(JSBridge(),"Android")
        binding.flourishApp.loadUrl("https://platform-stg.flourishfi.com/?lang=$language&token=$token")

        binding.flourishApp.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:(function() {" +
                        "function receiveMessage(event) {\n" +
                        "Android.receiveMessage(JSON.stringify(event.data));\n" +
                        "}" +
                        "window.addEventListener(\"message\", receiveMessage, false);"+
                        "})()"
                )
                Log.i("WEBVIEW", "onPageStarted "+url);
            }
        }
    }
}