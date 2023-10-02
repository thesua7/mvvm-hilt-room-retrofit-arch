package com.thesua7.mvvm_hilt_room_retrofit_arch.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.Data
import com.thesua7.mvvm_hilt_room_retrofit_arch.network.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val roomRepository:RoomRepository):ViewModel() {


    fun getAllRepositroyList():LiveData<List<Data>>{
        return roomRepository.getAllRecords()
    }
    fun makeApiCall(){
        roomRepository.makeApiCall()
    }
    fun makeUserCall(token:String,map:HashMap<String,String>){
        roomRepository.makeApiCallForUser(token,map)
    }
}