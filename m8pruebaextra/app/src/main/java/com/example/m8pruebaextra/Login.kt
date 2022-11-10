package com.example.m8pruebaextra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.m8pruebaextra.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var usuari = binding.usuari.text.toString()
        var contra = binding.contrasenya.text.toString()

        binding.btmRegistrar.setOnClickListener{
            val intent = Intent(this,Register::class.java)
            startActivity(intent)
            finish()
        }

        binding.btmLogin.setOnClickListener{
            usuari = binding.usuari.text.toString()
            contra = binding.contrasenya.text.toString()
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("usuari", usuari)
            intent.putExtra("contrasenya", contra)
            startActivity(intent)
        }

        if(intent.getStringExtra("user")!=null){
            usuari = intent.getStringExtra("user").toString()
            contra = intent.getStringExtra("contra").toString()
            binding.usuari.setText(usuari)
            binding.contrasenya.setText(contra)
        }
    }
}