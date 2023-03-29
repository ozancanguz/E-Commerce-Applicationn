package com.example.e_commerce_application.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.e_commerce_application.data.model.Product
import com.example.e_commerce_application.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListViewModel@Inject constructor(private val repository: Repository, application: Application):AndroidViewModel(application) {


    val productList=MutableLiveData<Product>()

    fun getAllProducts(){
        viewModelScope.launch {
            val response=repository.remote.getAllProducts()
            if(response.isSuccessful){
                productList.postValue(response.body())
            }else{
                Log.d("viewmodel","No data ")
            }
        }
    }


}