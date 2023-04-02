package com.example.e_commerce_application.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_commerce_application.R
import com.example.e_commerce_application.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}
