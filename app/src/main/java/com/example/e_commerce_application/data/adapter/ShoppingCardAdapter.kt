package com.example.e_commerce_application.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.model.entity.ProductEntity
import com.example.e_commerce_application.databinding.ShoppingCartItemRowLayoutBinding
import com.example.e_commerce_application.viewmodel.ProductViewModel
import javax.inject.Inject

class ShoppingCardAdapter@Inject constructor(private val viewModel:ProductViewModel): RecyclerView.Adapter<ShoppingCardAdapter.ShoppingCardViewHolder>() {

    inner class ShoppingCardViewHolder(val binding: ShoppingCartItemRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    private var productList = emptyList<ProductEntity>()

    private var totalPrice=0

    var totalPriceListener: OnTotalPriceChangeListener? = null


    fun setData(newData: List<ProductEntity>) {
        productList = newData

        for (product in productList) {
            totalPrice += product.price

        }
        // Call the listener to update the total price in the fragment
        totalPriceListener?.onTotalPriceChanged(totalPrice)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ShoppingCartItemRowLayoutBinding.inflate(inflater, parent, false)
        return ShoppingCardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ShoppingCardViewHolder, position: Int) {
        val currentProduct = productList[position]
        val binding = holder.binding

        binding.productNameTv.text = currentProduct.title
        binding.productpriceTV.text = "$" + currentProduct.price.toString()

        // Initialize the quantity of the product
        var quantity = 1

        binding.ivDelete.setOnClickListener {
            viewModel.deleteProductEntity(currentProduct)
        }

        binding.ivPlus.setOnClickListener {
            // Increase the quantity by 1
            quantity++
            binding.amounttv.text = quantity.toString()

            // Update the total price
            totalPrice += currentProduct.price
            totalPriceListener?.onTotalPriceChanged(totalPrice)
        }

        binding.ivMinus.setOnClickListener {
            // Decrease the quantity by 1
            if (quantity > 1) {
                quantity--
                binding.amounttv.text = quantity.toString()

                // Update the total price
                totalPrice -= currentProduct.price
                totalPriceListener?.onTotalPriceChanged(totalPrice)
            }
        }

        // Set the quantity of the product
        binding.amounttv.text = quantity.toString()
    }




    interface OnTotalPriceChangeListener {
        fun onTotalPriceChanged(totalPrice: Int)
    }

}