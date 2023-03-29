package com.example.e_commerce_application.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.model.Product
import com.example.e_commerce_application.data.model.ProductItem
import com.example.e_commerce_application.databinding.ProductsRowLayoutBinding

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    inner class ProductsViewHolder(private val binding: ProductsRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductItem) {
            binding.productName.text = product.title
            binding.productDescription.text = product.description
            binding.productPrice.text = product.price.toString()
        }
    }

    private var productList = emptyList<ProductItem>()

    fun setData(newData: Product) {
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
