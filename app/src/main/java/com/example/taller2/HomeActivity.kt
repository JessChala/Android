package com.example.taller2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity:AppCompatActivity() {
    private lateinit var buttonStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    //    val intent = Intent(this,LoginActivity::class.java)

        buttonStart=findViewById(R.id.btstarthome)


        buttonStart.setOnClickListener {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
        }

    }
}