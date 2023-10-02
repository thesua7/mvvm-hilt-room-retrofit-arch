package com.thesua7.mvvm_hilt_room_retrofit_arch.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.Data
import com.thesua7.mvvm_hilt_room_retrofit_arch.model.TypeConverterTitle


@Database(entities = [Data::class], version = 2, exportSchema = false)
@TypeConverters(TypeConverterTitle::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getDao():AppDao
    companion object{
        private var DB_INSTANCE : AppDatabase? = null

        fun getAppDBInstance(context: Context):AppDatabase{
            if (DB_INSTANCE==null){
                DB_INSTANCE = Room.databaseBuilder(context,AppDatabase::class.java,"DB").allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return DB_INSTANCE!!
        }
    }
}