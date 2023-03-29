package com.example.e_commerce_application.data.repository

import androidx.room.Dao
import com.example.e_commerce_application.data.api.ProductApi
import com.example.e_commerce_application.data.local.LocalDataSource
import com.example.e_commerce_application.data.remote.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(private var remoteDataSource: RemoteDataSource,
private var  localDataSource: LocalDataSource) {

     val remote=remoteDataSource
     val local=localDataSource

}