package com.example.e_commerce_application.ui.fragments.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.e_commerce_application.R
import com.example.e_commerce_application.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null

    private val binding get() = _binding!!

    private lateinit var auth:FirebaseAuth



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        val view = binding.root


        // init firebase auth
        auth= Firebase.auth

        // get current user e-mail
        getUserEmail()

        // seeFavorites
        SeeFavorites()

        return view
    }

    private fun getUserEmail(){
        val currentUserEmail= auth.currentUser?.email
        binding.useremailtv.text=currentUserEmail
    }

    private fun SeeFavorites(){
        binding.navFavbtn.setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_favoriteFragment)
        }

        binding.imageView3.setOnClickListener {
            findNavController().navigate(R.id.action_userFragment_to_favoriteFragment)

        }
    }


}