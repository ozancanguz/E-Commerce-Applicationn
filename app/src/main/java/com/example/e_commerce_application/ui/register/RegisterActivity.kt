package com.example.e_commerce_application.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.e_commerce_application.R
import com.example.e_commerce_application.databinding.ActivityRegisterBinding
import com.example.e_commerce_application.ui.login.LoginActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        FirebaseApp.initializeApp(this)
        // Initialize Firebase Auth
        auth = Firebase.auth

        // user sign up
        register()


    }

    private fun register() {
        binding.registerButton.setOnClickListener {
         //   binding.progressBar.visibility= View.VISIBLE

            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "E-mail or password empty", Toast.LENGTH_LONG).show()
             //   binding.progressBar.visibility= View.INVISIBLE

            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {

                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    startActivity(intent)
                //    binding.progressBar.visibility= View.INVISIBLE

                }.addOnFailureListener {
                    Toast.makeText(this@RegisterActivity, it.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }


    }
}