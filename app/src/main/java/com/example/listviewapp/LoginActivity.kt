package com.example.listviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.content.Intent
import com.example.listviewapp.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonLogin.setOnClickListener { login() }
    }
    private fun login(){

        val email = binding.emailField.text.toString()
        val password = binding.passwordField.text.toString()
        if (email == "nick@zuri.com" && password == "00000"){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "To login use Email:nick@zuri.com \n Password: 00000", Toast.LENGTH_LONG).show()
            binding.errorText.visibility = View.VISIBLE
        }
    }

}