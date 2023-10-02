package com.thesua7.mvvm_hilt_room_retrofit_arch.network

import com.thesua7.mvvm_hilt_room_retrofit_arch.model.OccupationModel
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.test.ResponseM


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface RetrofitServiceInterface {

    @GET("api/app_api/occupations")
    fun getResponseFromApi(): Call<OccupationModel>


    @Headers("Accept: application/json")
    @POST("api/app_api/user/update")
    fun getUserResponseFromApi(@Header("Authorization") token:String,@QueryMap params:Map<String,String>): Call<ResponseM>
}