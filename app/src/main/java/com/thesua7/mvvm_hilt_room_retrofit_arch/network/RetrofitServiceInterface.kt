package com.thesua7.mvvm_hilt_room_retrofit_arch.network

import com.thesua7.mvvm_hilt_room_retrofit_arch.model.OccupationModel
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInterface {

    @GET("api/app_api/occupations")
    fun getResponseFromApi(): Call<OccupationModel>
}