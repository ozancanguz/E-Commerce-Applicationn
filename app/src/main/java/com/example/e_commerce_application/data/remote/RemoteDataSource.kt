package com.example.e_commerce_application.data.remote

import com.example.e_commerce_application.data.api.ProductApi
import com.example.e_commerce_application.data.model.Product
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val productApi: ProductApi) {


    suspend fun getAllProducts(): Response<Product> {
        return productApi.getAllProducts()
    }
}