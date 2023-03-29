package com.example.e_commerce_application.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_application.data.model.entity.ProductEntity
import com.example.e_commerce_application.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductViewModel@Inject constructor( private val  repository: Repository, application: Application):AndroidViewModel(application) {




    // get all items
    val getAllProductEntity:LiveData<List<ProductEntity>>

    init {
        getAllProductEntity=repository.local.getAllProduct()
    }


    fun insertProductEntity(productEntity: ProductEntity){
        viewModelScope.launch {
            repository.local.insertProduct(productEntity)
        }
    }

    fun deleteProductEntity(productEntity: ProductEntity){
        viewModelScope.launch {
            repository.local.deleteProduct(productEntity)
        }
    }

    fun deleteAllEntity(){
        viewModelScope.launch {
            repository.local.deleteAllProduct()
        }
    }





}