package com.example.e_commerce_application.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_commerce_application.R
import com.example.e_commerce_application.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



    }
}