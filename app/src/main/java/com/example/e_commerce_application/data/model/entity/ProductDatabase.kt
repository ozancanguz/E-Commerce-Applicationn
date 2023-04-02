package com.example.e_commerce_application.data.model.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.e_commerce_application.data.model.favorites.FavoritesDao
import com.example.e_commerce_application.data.model.favorites.FavoritesEntity

@Database(entities = [ProductEntity::class,FavoritesEntity::class], version = 1,
    exportSchema = false,)

@TypeConverters(TypeConverter::class)
abstract class ProductDatabase: RoomDatabase(){
    abstract fun productDao():ProductDao
    abstract fun favoritesDao():FavoritesDao

}
