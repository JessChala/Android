package com.example.taller2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity:AppCompatActivity() {
    private lateinit var tvNombre: TextView
    private lateinit var tvApellido: TextView
    private lateinit var tvCorreo: TextView
    private lateinit var tvTelefono: TextView
    private lateinit var btnEditar: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        tvNombre = findViewById(R.id.tvNameappperfil)
        tvApellido = findViewById(R.id.tvLastNameperfil)
        tvCorreo = findViewById(R.id.tvEmailperfil)
        tvTelefono = findViewById(R.id.tvPhoneperfil)
        btnEditar = findViewById(R.id.btnEditProfile)

        cargarDatosUsuario()

       // Me falta crear la vista para editar el  usuario
        btnEditar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
    private fun cargarDatosUsuario() {
        val nombre = sharedPreferences.getString("nombre", "No registrado")
        val apellido = sharedPreferences.getString("apellido", "No registrado")
        val correo = sharedPreferences.getString("correo", "No registrado")
        val telefono = sharedPreferences.getString("telefono", "No registrado")


        tvNombre.text = "Nombre: $nombre"
        tvApellido.text = "Apellido: $apellido"
        tvCorreo.text = "Correo: $correo"
        tvTelefono.text = "Teléfono: $telefono"
    }


}