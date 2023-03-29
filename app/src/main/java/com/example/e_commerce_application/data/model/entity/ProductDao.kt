package com.example.e_commerce_application.data.model.entity

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("select * from products_table order by id ASC")
     fun getAllProduct():LiveData<List<ProductEntity>>

     @Insert
    suspend fun insertProduct(productEntity: ProductEntity)

    @Delete
    suspend fun deleteProduct(productEntity: ProductEntity)

    @Query("delete from products_table")
    suspend fun deleteAllProduct()



}