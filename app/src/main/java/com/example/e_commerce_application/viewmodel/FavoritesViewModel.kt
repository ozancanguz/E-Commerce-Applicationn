package com.example.e_commerce_application.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_application.data.model.entity.ProductEntity
import com.example.e_commerce_application.data.model.favorites.FavoritesEntity
import com.example.e_commerce_application.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: Repository,application: Application):AndroidViewModel(application){

    // get all items
    val getAllFavorites:LiveData<List<FavoritesEntity>>

    init {
        getAllFavorites=repository.local.getAllFavorites()
    }


    fun insertFavorite(favoritesEntity: FavoritesEntity){
        viewModelScope.launch {
            repository.local.inserFavorite(favoritesEntity)
        }
    }

    fun deleteFavorite(favoritesEntity: FavoritesEntity){
        viewModelScope.launch {
            repository.local.deleteFavorite(favoritesEntity)
        }
    }

    fun deletAllFavorites(){
        viewModelScope.launch {
            repository.local.deleteAllFavorites()
        }
    }




}