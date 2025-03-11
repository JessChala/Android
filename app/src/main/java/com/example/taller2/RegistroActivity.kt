package com.example.taller2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity:AppCompatActivity() {

    private lateinit var editTextNombres: EditText
    private lateinit var editTextApellidos: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var editTextContrasena: EditText
    private lateinit var buttonRegistro: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        Log.d("RegistroActivity", "onCreate: Registro Activity Iniciado")

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        editTextNombres=findViewById(R.id.etNameRegister)
        editTextApellidos=findViewById(R.id.etLastNameRegister)
        editTextCorreo=findViewById(R.id.etEmailRegister)
        editTextTelefono=findViewById(R.id.etPhoneRegister)
        editTextContrasena=findViewById(R.id.etPassRegister)
        buttonRegistro=findViewById(R.id.btRegisterRegister)

        buttonRegistro.setOnClickListener {
            if (validarCampos()) {
            //Metodo de guardar todos los datos y redireccionar
                guardarDatosUsuario()
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
    }

        private fun validarCampos(): Boolean {
            val nombres = editTextNombres.text.toString().trim()
            val apellidos = editTextApellidos.text.toString().trim()
            val correo = editTextCorreo.text.toString().trim()
            val telefono = editTextTelefono.text.toString().trim()
            val contrasena = editTextContrasena.text.toString().trim()
            if (nombres.isEmpty()) {
                Toast.makeText(this, "El nombre es obligatorio", Toast.LENGTH_SHORT).show()
                return false
            }
            if (apellidos.isEmpty()) {
                Toast.makeText(this, "El apelleido es obligatorio", Toast.LENGTH_SHORT).show()
                return false
            }
            if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                Toast.makeText(this, "El correo es obligatorio", Toast.LENGTH_SHORT).show()
                return false
            }
            if (telefono.isEmpty() || telefono.length < 10) {
                Toast.makeText(this, "El telefono es obligatorio", Toast.LENGTH_SHORT).show()
                return false
            }
            if (contrasena.isEmpty() || contrasena.length < 10) {
                Toast.makeText(this, "Minimo 10 caracteres", Toast.LENGTH_SHORT).show()
                return false
            }
            return true
        }
        private fun correoExistente(correo: String): Boolean {
        val correoGuardado = sharedPreferences.getString("correo", "")
        return correo == correoGuardado
    }

        private fun guardarDatosUsuario (){
            if (correoExistente(editTextCorreo.text.toString().trim())) {
                Toast.makeText(this, "El correo ya está registrado", Toast.LENGTH_SHORT).show()
                return
            }
            val editor = sharedPreferences.edit()
            editor.putString("nombre",editTextNombres.text.toString().trim())
            editor.putString("apellidos", editTextApellidos.text.toString().trim())
            editor.putString("correo", editTextCorreo.text.toString().trim())
            editor.putString("telefono", editTextTelefono.text.toString().trim())
            editor.putString("contrasena", editTextContrasena.text.toString().trim())
            editor.apply()
            Log.d("Registro Activity","guardarDatosUsuario: Los datos han sido guardados")
            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show()
        }



}