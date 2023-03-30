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

class ShoppingCardAdapter@Inject constructor(val viewModel:ProductViewModel): RecyclerView.Adapter<ShoppingCardAdapter.ShoppingCardViewHolder>() {

    inner class ShoppingCardViewHolder(val binding: ShoppingCartItemRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }


    private var productList = emptyList<ProductEntity>()

    fun setData(newData: List<ProductEntity>) {
        productList = newData
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
        binding.productpriceTV.text = currentProduct.price.toString()


            binding.ivDelete.setOnClickListener {
                viewModel.deleteProductEntity(currentProduct)

        }





    }

}
