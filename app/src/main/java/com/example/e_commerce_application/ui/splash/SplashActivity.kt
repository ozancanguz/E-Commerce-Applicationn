package com.example.e_commerce_application.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_commerce_application.databinding.ActivitySplashBinding
import com.example.e_commerce_application.ui.login.LoginActivity
import com.example.e_commerce_application.ui.register.RegisterActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
//splash ekran için bir Thread oluşturuyoruz
        val background = object : Thread() {
            override fun run() {
                try {

                    Thread.sleep(7000)
                    val intent = Intent(baseContext, LoginActivity::class.java)
                    startActivity(intent)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()

    }
}