package com.example.e_commerce_application.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
    val description: String,
    val id: String,
    val imageUrl: String,
    val price: Int,
    val title: String
): Parcelable