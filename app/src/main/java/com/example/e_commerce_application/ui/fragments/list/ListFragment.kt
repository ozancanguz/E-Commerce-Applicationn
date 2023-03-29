package com.example.e_commerce_application.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.adapter.ImagesAdapter
import com.example.e_commerce_application.data.adapter.ProductsAdapter
import com.example.e_commerce_application.databinding.FragmentListBinding
import com.example.e_commerce_application.viewmodel.ListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    private val adapter=ProductsAdapter()
    private val imagesAdapter=ImagesAdapter()
    private val listViewModel:ListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root


        // setup recyclerview
        setupRv()

        // observe live data and update ui
        observeLiveData()





        return view



    }

    private fun setupRv() {
        binding.productRv.layoutManager=LinearLayoutManager(requireContext())
        binding.productRv.adapter=adapter
    }

    private fun observeLiveData() {
        binding.progressBar.visibility=View.VISIBLE
        listViewModel.getAllProducts()
        listViewModel.productList.observe(viewLifecycleOwner, Observer {products ->
            adapter.setData(products)
            binding.progressBar.visibility=View.INVISIBLE

        })
     }


}