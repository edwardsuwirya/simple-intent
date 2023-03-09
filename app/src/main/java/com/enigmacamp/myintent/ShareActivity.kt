package com.enigmacamp.myintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)
        intent?.let {
            when (it.action) {
                Intent.ACTION_SEND -> {
                    if (it.type == "text/plain") {
                        Log.d("Share-Activity", it.getStringExtra(Intent.EXTRA_TEXT).toString())
                    }
                }
            }
        }
    }
}