package com.example.e_commerce_application.ui.fragments.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.adapter.FavoritesAdapter
import com.example.e_commerce_application.databinding.FragmentFavoriteBinding
import com.example.e_commerce_application.viewmodel.FavoritesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null

    private val binding get() = _binding!!

    private val favadapter=FavoritesAdapter()

    private val favoritesViewModel:FavoritesViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root


        // setting up recyclerview
        setupRv()

        // observe live data and update ui
        observeFavoriteLiveData()

        return view



    }

    private fun observeFavoriteLiveData() {
        favoritesViewModel.getAllFavorites.observe(viewLifecycleOwner, Observer {
            favadapter.setData(it)
        })
    }

    private fun setupRv() {
        binding.favRv.layoutManager=LinearLayoutManager(requireContext())
        binding.favRv.adapter=favadapter
    }


}