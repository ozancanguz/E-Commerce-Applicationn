package com.example.e_commerce_application.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "products_table" )
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    val title: String,
    val price: Int,
    var quantity:Int
    )
