package com.example.m8pruebaextra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.m8pruebaextra.databinding.ActivityLoginBinding
import com.example.m8pruebaextra.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btmLogin.setOnClickListener{
            var us = binding.usuari.text.toString()
            var contra1 = binding.contrasenya.text.toString()
            var contra2 = binding.confirmarContrasenya.text.toString()
            val intent = Intent(this,Login::class.java)
            intent.putExtra("user", us)
            intent.putExtra("contra",contra1)
            if(us == ""){
                Toast.makeText(this,"L'usuari no pot estar buit",Toast.LENGTH_SHORT).show()
            }else if(contra1 != contra2){
                Toast.makeText(this,"Les contrasenyes no son iguals",Toast.LENGTH_SHORT).show()
            }else{
                startActivity(intent)
            }
        }

    }
}