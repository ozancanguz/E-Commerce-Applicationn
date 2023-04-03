package com.example.e_commerce_application.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerce_application.R
import com.example.e_commerce_application.data.model.favorites.FavoritesEntity
import com.example.e_commerce_application.databinding.FavItemRowLayoutBinding
import com.example.e_commerce_application.viewmodel.FavoritesViewModel

class FavoritesAdapter(private val viewModel:FavoritesViewModel): RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {

    inner class FavoritesViewHolder(private val binding: FavItemRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favorite: FavoritesEntity) {
            binding.favproductNameTv.text = favorite.favTitle
            binding.favproductpriceTV.text = "$" + favorite.favPrice.toString()


            binding.favivDelete.setOnClickListener {
                viewModel.deleteFavorite(favorite)
            }

        }
    }

    var favoriteList = emptyList<FavoritesEntity>()

    fun setData(newData: List<FavoritesEntity>) {
        this.favoriteList = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val binding = FavItemRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return favoriteList.size
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val currentFav = favoriteList[position]
        holder.bind(currentFav)

    }
}
