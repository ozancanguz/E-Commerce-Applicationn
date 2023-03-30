package com.example.e_commerce_application.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController


import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.model.ProductItem
import com.example.e_commerce_application.data.model.entity.ProductEntity
import com.example.e_commerce_application.databinding.ProductsRowLayoutBinding
import com.example.e_commerce_application.ui.fragments.list.ListFragmentDirections
import com.example.e_commerce_application.util.Util.Companion.loadImage
import com.example.e_commerce_application.viewmodel.ProductViewModel

class ProductsAdapter() : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    inner class ProductsViewHolder(private val binding: ProductsRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductItem) {
            binding.productName.text = product.title
            binding.productDescription.text = product.description
            binding.productPrice.text = product.price.toString()+"$"
            binding.productImage.loadImage(product.imageUrl)

            binding.cardView.setOnClickListener {
                val directions = ListFragmentDirections.actionListFragmentToProductDetailsFragment(productList[position])
                binding.cardView.findNavController().navigate(directions)
            }



        }
    }

    private var productList = emptyList<ProductItem>()

    fun setData(newData: List<ProductItem>) {
        productList = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding = ProductsRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
