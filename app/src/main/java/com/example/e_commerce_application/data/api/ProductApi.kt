package com.example.e_commerce_application.data.api

import com.example.e_commerce_application.data.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getAllProducts(): Response<Product>


}