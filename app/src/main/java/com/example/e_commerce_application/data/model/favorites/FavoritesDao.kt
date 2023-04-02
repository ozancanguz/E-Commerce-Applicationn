package com.example.e_commerce_application.data.model.favorites

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritesDao {


          @Query("select * from favorites_table order by id asc")
          fun getAllFavorites():LiveData<List<FavoritesEntity>>

          @Insert
          suspend fun insertFavorite(favoritesEntity: FavoritesEntity)

          @Delete
          suspend fun deleteSingleFavorite(favoritesEntity: FavoritesEntity)

          @Query("delete from favorites_table")
          suspend fun deleteAllFavorites()

}