package com.example.e_commerce_application.ui.fragments.card

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.adapter.ProductsAdapter
import com.example.e_commerce_application.data.adapter.ShoppingCardAdapter
import com.example.e_commerce_application.databinding.FragmentCardBinding
import com.example.e_commerce_application.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardFragment : Fragment(),ShoppingCardAdapter.OnTotalPriceChangeListener {

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
        productsAdapter= ShoppingCardAdapter(productViewModel)

        // setting up recyclerview
        setupRv()

        // observe live data and update ui
        observeLiveData()

        // set menu
        setHasOptionsMenu(true)

        productsAdapter.totalPriceListener = this


         order()



        super.onViewCreated(view, savedInstanceState)
    }

    private fun order(){
        binding.orderBtn.setOnClickListener {
            findNavController().navigate(R.id.action_cardFragment_to_listFragment)
            productViewModel.deleteAllEntity()
            binding.totalPriceTv.text= "0".toString().toInt().toString()
            Toast.makeText(requireContext(),"Order completed",Toast.LENGTH_LONG).show()
        }
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.shoppingcardmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.deleteAll){
            productViewModel.deleteAllEntity()
            binding.totalPriceTv.text="0".toString()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onTotalPriceChanged(totalPrice: Int) {
        // Update the UI with the new total price
        binding.totalPriceTv.text = "$totalPrice USD"
    }

}