package com.example.e_commerce_application.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.model.Product
import com.example.e_commerce_application.data.model.ProductItem
import com.example.e_commerce_application.databinding.ImagesrowlayoutBinding
import com.example.e_commerce_application.util.Util.Companion.loadImage

class ImagesAdapter : RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>() {

    class ImagesViewHolder(private val binding: ImagesrowlayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(productItem: ProductItem) {
            binding.imageview.loadImage(productItem.imageUrl)
        }
    }

    var images = emptyList<ProductItem>()

    fun setImagesData(newData: List<ProductItem>) {
        images = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ImagesrowlayoutBinding.inflate(inflater, parent, false)
        return ImagesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val currentImage = images[position]
        holder.bind(currentImage)
    }
}
