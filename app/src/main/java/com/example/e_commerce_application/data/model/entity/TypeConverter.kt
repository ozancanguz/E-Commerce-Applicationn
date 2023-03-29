package com.example.e_commerce_application.data.model.entity

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
}