package com.example.e_commerce_application.ui.fragments.productDetails

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.model.entity.ProductEntity
import com.example.e_commerce_application.databinding.FragmentProductDetailsBinding
import com.example.e_commerce_application.util.Util.Companion.loadImage
import com.example.e_commerce_application.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:ProductDetailsFragmentArgs by navArgs()

    private val productViewModel:ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        // getDetails
        getDetails()

        // insert to db
        insertDb()


        // set menu
        setHasOptionsMenu(true)

        return view


    }

    private fun getDetails() {
        binding.imageView.loadImage(args.details.imageUrl)
        binding.detailsPrice.text=args.details.price.toString()
        binding.detailsTitle.text=args.details.title
    }


    private fun insertDb(){
        binding.addCart.setOnClickListener {
            val price=binding.detailsPrice.text.toString().toInt()
            val title=binding.detailsTitle.text.toString()
            val newItem=ProductEntity(0,title,price)
            productViewModel.insertProductEntity(newItem)
            Toast.makeText(requireContext(),"Item added to card",Toast.LENGTH_LONG).show()
            Log.d("hello", " $newItem")

        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detailsmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.card){
            findNavController().navigate(R.id.action_productDetailsFragment_to_cardFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}