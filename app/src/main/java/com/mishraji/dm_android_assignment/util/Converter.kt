package com.mishraji.dm_android_assignment.util

import androidx.room.TypeConverter
import com.mishraji.dm_android_assignment.data.Topping

class Converter {
    @TypeConverter
    fun toTopping(item: String): List<Topping> {
        val list = mutableListOf<Topping>()

        val array = item.split(",".toRegex()).dropLastWhile {
            it.isEmpty()
        }.toTypedArray()

        for (s in array) {
            if (s.isNotEmpty()) {
                list.add(Topping(s.split(":")[0].toInt(), s.split(":")[1]))
            }
        }
        return list
    }

    @TypeConverter
    fun fromTopping(list: List<Topping>): String {
        var genreIds=""
        for (i in list) genreIds += ",${i.id}:${i.type}"
        return genreIds
    }
}