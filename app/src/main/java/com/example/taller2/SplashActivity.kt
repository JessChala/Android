package com.example.taller2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashActivity:AppCompatActivity() {
    private val splash_time_out: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d("SplashActivity", "onCreate:Iniciando Activity Splash")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, splash_time_out)
    }

    override fun onStart() {
        super.onStart()
        Log.d("SplashActivity", "onStart:Activity Splash esta en primer plano")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SplashActivity", "onPause:Activity Splash esta pausada")
    }
    override fun onResume() {
        super.onResume()
        Log.d("SplashActivity", "onResume:Activity Splash esta pausada")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashActivity", "onDestroy:Activity Splash esta pausada")
    }
    override fun onStop() {
        super.onStop()
        Log.d("SplashActivity", "onStop:Activity Splash esta pausada")
    }

}