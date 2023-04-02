package com.example.e_commerce_application.data.local

import androidx.lifecycle.LiveData
import com.example.e_commerce_application.data.model.entity.ProductDao
import com.example.e_commerce_application.data.model.entity.ProductEntity
import com.example.e_commerce_application.data.model.favorites.FavoritesDao
import com.example.e_commerce_application.data.model.favorites.FavoritesEntity
import javax.inject.Inject

class LocalDataSource@Inject constructor(private val productDao: ProductDao,private val
favoritesDao: FavoritesDao) {


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

    fun getAllFavorites():LiveData<List<FavoritesEntity>>{
        return favoritesDao.getAllFavorites()
    }

    suspend fun inserFavorite(favoritesEntity: FavoritesEntity){
        return favoritesDao.insertFavorite(favoritesEntity)
    }

    suspend fun deleteFavorite(favoritesEntity: FavoritesEntity){
        return favoritesDao.deleteSingleFavorite(favoritesEntity)
    }

    suspend fun deleteAllFavorites(){
        return favoritesDao.deleteAllFavorites()
    }






}