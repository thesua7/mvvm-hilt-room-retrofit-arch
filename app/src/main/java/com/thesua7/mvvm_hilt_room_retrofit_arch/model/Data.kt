package com.thesua7.mvvm_hilt_room_retrofit_arch.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@Entity(tableName = "occupations")
data class Data(
    @PrimaryKey
    val id: Int,

    @TypeConverters(TypeConverterTitle::class)
    val title: Title
)


class TypeConverterData {
    val gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Data? {
        if (data == null) return null
        val listType: Type = object : TypeToken<Data?>() {}.type
        return gson.fromJson<Data?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someobject: Data?): String? {
        return gson.toJson(someobject)
    }
}