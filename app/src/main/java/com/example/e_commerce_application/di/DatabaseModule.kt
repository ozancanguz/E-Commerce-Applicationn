package com.example.e_commerce_application.di

import android.content.Context
import androidx.room.Room
import com.example.e_commerce_application.data.model.entity.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ProductDatabase::class.java,
        "product_database"
    ).build()


    @Singleton
    @Provides
    fun provideDao(database: ProductDatabase) = database.productDao()

       @Singleton
    @Provides
    fun provideFavoriteDao(database: ProductDatabase) = database.favoritesDao()





}