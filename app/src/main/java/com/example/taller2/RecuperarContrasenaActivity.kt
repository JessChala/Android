package com.example.taller2

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller2.R.id.etEmailRecuperar
import org.intellij.lang.annotations.Pattern

class RecuperarContrasenaActivity:AppCompatActivity() {

    private lateinit var editTextCorreo:EditText
    private lateinit var buttonSend:Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperacion_contrasena)

        sharedPreferences = getSharedPreferences("userData", MODE_PRIVATE)
        editTextCorreo=findViewById(etEmailRecuperar)
        buttonSend=findViewById(R.id.btRegisterRecuperar)


        buttonSend.setOnClickListener{
            if(validarCorreo()){
                verificarCorreo()
            }
        }
    }
private fun validarCorreo():Boolean{
    val correo=editTextCorreo.text.toString().trim()
    if(correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()){
        Toast.makeText(this, "Debe ingresar el correo.", Toast.LENGTH_SHORT).show()
        return false
        }
        return true
    }

    private fun verificarCorreo(){
        val correo=editTextCorreo.text.toString().trim()
        val correoRegistrado = sharedPreferences.getString("correo","")
        if(correo==correoRegistrado){
            Toast.makeText(this, "Se ha enviado el correo para recuperar la contrasena.", Toast.LENGTH_SHORT).show()
            //Redireccionar
            buttonSend.postDelayed({
                finish()
            },1500)
        } else {
            Toast.makeText(this, "El correo ingresado no existe.", Toast.LENGTH_SHORT).show()
            buttonSend.postDelayed({
                finish()
            },1500)
        }
    }
}