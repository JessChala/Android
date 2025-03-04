package com.example.taller2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity:AppCompatActivity() {
    private lateinit var btnIngresar: Button
    private lateinit var tvRegistrarse: Button
    private lateinit var tvRecuperar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnIngresar = findViewById<Button>(R.id.btintologin)
        val tvRegistrarse = findViewById<TextView>(R.id.tvregisterlogin)
        val tvRecuperar = findViewById<TextView>(R.id.tvrecoverpass)

        tvRegistrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        // Ir a Registro cuando se hace clic en "Ingresar"
        btnIngresar.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        tvRecuperar.setOnClickListener {
            val intent = Intent(this, RecuperarContrasenaActivity::class.java)
            startActivity(intent)
        }
    }
}