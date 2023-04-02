package com.example.e_commerce_application.data.model.entity

import com.example.e_commerce_application.data.model.favorites.FavoritesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConverter {

    var gson = Gson()

    @androidx.room.TypeConverter
    fun ProductListToString(productEntity:List<ProductEntity>): String {
        return gson.toJson(productEntity)
    }

    @androidx.room.TypeConverter
    fun stringToProductList(data: String): List<ProductEntity> {
        val listType = object : TypeToken<List<ProductEntity>>() {}.type
        return gson.fromJson(data, listType)
    }



    @androidx.room.TypeConverter
    fun ProductListToStringg(favoritesEntity:List<FavoritesEntity>): String {
        return gson.toJson(favoritesEntity)
    }

    @androidx.room.TypeConverter
    fun stringToProductListt(data: String): List<FavoritesEntity> {
        val listType = object : TypeToken<List<FavoritesEntity>>() {}.type
        return gson.fromJson(data, listType)
    }
}