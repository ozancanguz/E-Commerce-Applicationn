package com.example.e_commerce_application.data.model.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ProductEntity::class], version = 2,
    exportSchema = false,)

@TypeConverters(TypeConverter::class)
abstract class ProductDatabase: RoomDatabase(){
    abstract fun productDao():ProductDao

}
