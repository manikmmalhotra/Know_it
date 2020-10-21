package com.example.knowit

import android.app.Activity
import android.os.AsyncTask
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.knowit.db.ContentDataBase
import com.example.knowit.db.ContentDb
import kotlinx.android.synthetic.main.activity_web.*

class web : AppCompatActivity() {

    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.webView)

        var name : String? = intent.getStringExtra("name")
        var author : String? = intent.getStringExtra("author")
        var web : String? = intent.getStringExtra("web")
        var img : String? = intent.getStringExtra("img")
        var descr : String? = intent.getStringExtra("descr")
        var title : String? = intent.getStringExtra("title")
        var date : String? = intent.getStringExtra("date")

        val contentDb = ContentDb(name!!,author!!,title!!,web!!,img!!,date!!,descr!!)

        webView.webViewClient = MyWebViewClient(this)
        webView.loadUrl(web!!)

        fab.setOnClickListener {
            savedContent(contentDb)
        }


    }

    private fun savedContent(content:ContentDb){
        class SavedContent : AsyncTask<Void,Void,Void>(){
            override fun doInBackground(vararg params: Void?): Void? {
                ContentDataBase(applicationContext).getContentDao().addContent(content)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)

                Toast.makeText(applicationContext,"saved",Toast.LENGTH_LONG).show()
            }

        }
        SavedContent().execute()
    }






    class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }
    }

}