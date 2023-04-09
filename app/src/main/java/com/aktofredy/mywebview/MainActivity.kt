package com.aktofredy.mywebview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.aktofredy.mywebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.webView.apply {
            settings.javaScriptEnabled = true

            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)

                    view.loadUrl("javascript:alert('Web Dicoding berhasil dimuat')")
                }
            }
        }

        binding.webView.apply {
            webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: JsResult
                ): Boolean {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                    result.confirm()

                    return true
                }
            }

            loadUrl("https://qbtr.cc/tongren")
        }

    }
}