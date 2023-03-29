package com.example.e_commerce_application.data.local

import androidx.lifecycle.LiveData
import com.example.e_commerce_application.data.model.entity.ProductDao
import com.example.e_commerce_application.data.model.entity.ProductEntity
import javax.inject.Inject

class LocalDataSource@Inject constructor(private val productDao: ProductDao) {


     fun getAllProduct():LiveData<List<ProductEntity>>{
        return productDao.getAllProduct()
    }


    suspend fun insertProduct(productEntity: ProductEntity){
        return productDao.insertProduct(productEntity)
    }

    suspend fun deleteProduct(productEntity: ProductEntity){
        return productDao.deleteProduct(productEntity)
    }


    suspend fun deleteAllProduct(){
        return productDao.deleteAllProduct()
    }



}