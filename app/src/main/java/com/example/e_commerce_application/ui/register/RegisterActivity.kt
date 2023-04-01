package com.example.e_commerce_application.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_commerce_application.R
import com.example.e_commerce_application.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}