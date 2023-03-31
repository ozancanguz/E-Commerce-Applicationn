package com.example.e_commerce_application.ui.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce_application.data.adapter.ProductsAdapter
import com.example.e_commerce_application.databinding.FragmentListBinding
import com.example.e_commerce_application.viewmodel.ListViewModel
import com.example.e_commerce_application.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!


    private lateinit var listViewModel: ListViewModel
    private lateinit var productViewModel: ProductViewModel

    private lateinit var adapter: ProductsAdapter



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        listViewModel= ViewModelProvider(this)[ListViewModel::class.java]
        productViewModel= ViewModelProvider(this)[ProductViewModel::class.java]
         adapter=ProductsAdapter()

        // setup recyclerview
        setupRv()

        // observe live data and update ui
        observeLiveData()


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}