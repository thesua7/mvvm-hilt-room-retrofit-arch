package com.thesua7.mvvm_hilt_room_retrofit_arch.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type



data class Title(
    val bn: String,
    val en: String
)

class TypeConverterTitle {
    val gson: Gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): Title? {
        if (data == null) return null
        val listType: Type = object : TypeToken<Title?>() {}.type
        return gson.fromJson<Title?>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someobject: Title?): String? {
        return gson.toJson(someobject)
    }
}