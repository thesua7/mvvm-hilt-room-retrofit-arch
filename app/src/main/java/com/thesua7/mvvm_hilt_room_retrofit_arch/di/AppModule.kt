package com.thesua7.mvvm_hilt_room_retrofit_arch.di

import android.app.Application
import android.content.Context
import com.thesua7.mvvm_hilt_room_retrofit_arch.db.AppDao
import com.thesua7.mvvm_hilt_room_retrofit_arch.db.AppDatabase
import com.thesua7.mvvm_hilt_room_retrofit_arch.network.RetrofitServiceInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    val BASE_URL = "https://karmasangsthan.com.bd/"
    @Provides
    @Singleton
    fun getAppDatabase(context: Application):AppDatabase{
        return AppDatabase.getAppDBInstance(context)
    }
    @Provides
    @Singleton
    fun getAppDao(appDatabase: AppDatabase):AppDao{
        return appDatabase.getDao()
    }


    @Provides
    @Singleton
    fun getRetroInstance():Retrofit{
        return  Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun getRetroServiceInstance(retrofit: Retrofit):RetrofitServiceInterface{
        return  retrofit.create(RetrofitServiceInterface::class.java)
    }


}