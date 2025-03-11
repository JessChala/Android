package com.example.taller2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var btnIngresar: Button
    private lateinit var tvRegistrarse: TextView
    private lateinit var tvRecuperar: TextView
    private lateinit var etUserCorreo: EditText
    private lateinit var etPassword: EditText

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar SharedPreferences
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        // Asociar las variables con las vistas
        btnIngresar = findViewById(R.id.btintologin)
        tvRegistrarse = findViewById(R.id.tvregisterlogin)
        tvRecuperar = findViewById(R.id.tvrecoverpass)
        etUserCorreo = findViewById(R.id.etnamereglogin)
        etPassword = findViewById(R.id.etpassreglogin)


        tvRegistrarse.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        tvRecuperar.setOnClickListener {
            val intent = Intent(this, RecuperarContrasenaActivity::class.java)
            startActivity(intent)
        }

        btnIngresar.setOnClickListener {
            validarLogin()
        }
    }

    private fun validarLogin() {
        val correoIngresado = etUserCorreo.text.toString().trim()
        val contrasenaIngresada = etPassword.text.toString().trim()

        val correoGuardado = sharedPreferences.getString("correo", null)
        val contrasenaGuardada = sharedPreferences.getString("contrasena", null)

        if (correoIngresado.isEmpty() || contrasenaIngresada.isEmpty()) {
            Toast.makeText(this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (correoIngresado == correoGuardado && contrasenaIngresada == contrasenaGuardada) {
            Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()

            // Ir al perfil
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }
}
