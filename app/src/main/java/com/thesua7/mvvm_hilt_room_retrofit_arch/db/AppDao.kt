package com.thesua7.mvvm_hilt_room_retrofit_arch.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.Data
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.Title


@Dao
interface AppDao {

    @Query("Select * from occupations")
    fun getRecords(): LiveData<List<Data>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(occupation: Data)

    @Query("Delete from occupations")
    fun deleteAllRecords()

}