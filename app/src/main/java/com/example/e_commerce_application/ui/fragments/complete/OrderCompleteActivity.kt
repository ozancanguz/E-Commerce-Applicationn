package com.example.e_commerce_application.ui.fragments.complete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_commerce_application.databinding.ActivityOrderCompleteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderCompleteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderCompleteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}