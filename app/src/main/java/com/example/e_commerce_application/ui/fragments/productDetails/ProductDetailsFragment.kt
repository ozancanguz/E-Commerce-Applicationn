package com.example.e_commerce_application.ui.fragments.productDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.e_commerce_application.R
import com.example.e_commerce_application.databinding.FragmentProductDetailsBinding
import com.example.e_commerce_application.util.Util.Companion.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:ProductDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        // getDetails
        getDetails()


        return view


    }

    private fun getDetails() {
        binding.imageView.loadImage(args.details.imageUrl)
        binding.detailsPrice.text=args.details.price.toString()
        binding.detailsTitle.text=args.details.title
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        super.onViewCreated(view, savedInstanceState)
    }
}