package com.example.e_commerce_application.ui.fragments.card

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce_application.data.adapter.ProductsAdapter
import com.example.e_commerce_application.data.adapter.ShoppingCardAdapter
import com.example.e_commerce_application.databinding.FragmentCardBinding
import com.example.e_commerce_application.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardFragment : Fragment() {

    private var _binding: FragmentCardBinding? = null

    private val binding get() = _binding!!

    private lateinit var productViewModel: ProductViewModel
    private lateinit var productsAdapter: ShoppingCardAdapter




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCardBinding.inflate(inflater, container, false)
        val view = binding.root


        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        productViewModel=ViewModelProvider(this).get(ProductViewModel::class.java)
        productsAdapter= ShoppingCardAdapter()

        // setting up recyclerview
        setupRv()

        // observe live data and update ui
        observeLiveData()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeLiveData() {
        productViewModel.getAllProductEntity.observe(viewLifecycleOwner, Observer {
            productsAdapter.setData(it)
        })
    }

    private fun setupRv() {
       binding.cardRv.layoutManager=LinearLayoutManager(requireContext())
        binding.cardRv.adapter=productsAdapter
    }

}