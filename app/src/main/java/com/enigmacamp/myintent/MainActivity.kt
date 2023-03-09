package com.enigmacamp.myintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/*
Intent adalah sebuah messaging object yang berfungsi untuk menerima action dari android component lainnya
Use Case yang umum digunakan:
1. Memanggil activity : menggunakan startActivity()
2. Menjalankan service : sebuah component android yang berjalan di background tanpa user interface.
   menggunakan startService()
3. Menjalankan Broadcast : sebuah message yang akan diterima oleh semua aplikasi yang ada di device.
   Android system memiliki fitur melakukan broadcast message apabila terjadi perubahan system event,
   seperti device sedang dilakukan charging, dll.
   menggunakan sendBroadcast()

Intent dibagi menjadi 2:
- Explicit Intent : intent yang akan melakukan pemanggilan component di dalam aplikasi yang sama
- Implicit Intent: intent yang akan melakukan pemanggilan aplikasi lainnya di dalam device yang sama
  contohnya : membuka aplikasi browser,aplikasi email,aplikasi telepon, dll
  https://developer.android.com/guide/components/intents-common

Aplikasi yang kita buat juga bisa menerima sebuah intent dari aplikasi lainnya
menggunkan tag elemen <intent-filter> di androidManifest.xml
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnNextActivity = findViewById<Button>(R.id.btn_next)
        val btnShare = findViewById<Button>(R.id.btn_share)
        btnNextActivity.setOnClickListener {
            val explicitIntent = Intent(this, SecondActivity::class.java)
            startActivity(explicitIntent)
        }

        btnShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "123")
                type = "text/plain"
            }
            startActivity(sendIntent)
        }
    }
}