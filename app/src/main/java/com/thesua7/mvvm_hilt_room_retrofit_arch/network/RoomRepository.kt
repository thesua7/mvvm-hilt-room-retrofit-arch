package com.thesua7.mvvm_hilt_room_retrofit_arch.network

import android.util.Log
import androidx.lifecycle.LiveData
import com.thesua7.mvvm_hilt_room_retrofit_arch.db.AppDao
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.Data
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.OccupationModel
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.Title
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val retrofitServiceInterface: RetrofitServiceInterface,
    private val appDao:AppDao
) {
    fun getAllRecords(): LiveData<List<Data>> {
        return appDao.getRecords()
    }
    fun insertRecord(repositoryData: Data){
        appDao.insertRecords(repositoryData)
    }

    fun makeApiCall(){
        val call:Call<OccupationModel> = retrofitServiceInterface.getResponseFromApi()
        call?.enqueue(object :Callback<OccupationModel>{
            override fun onResponse(call: Call<OccupationModel>, response: Response<OccupationModel>) {
              if(response.isSuccessful){
                  response.body()?.data?.forEach{
                      insertRecord(it)
                  }
              }
            }

            override fun onFailure(call: Call<OccupationModel>, t: Throwable) {
                Log.d("asdasd",t.message.toString())
            //nothing
            }
        })
    }
}