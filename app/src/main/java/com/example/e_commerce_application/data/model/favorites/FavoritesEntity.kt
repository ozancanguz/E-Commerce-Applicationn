package com.example.e_commerce_application.data.model.favorites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table" )
data class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    val favTitle: String,
    val favPrice: Int,
    var favQuantity:Int
)
