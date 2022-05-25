package com.mishraji.dm_android_assignment.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mishraji.dm_android_assignment.util.Converter

@TypeConverters(Converter::class)
@Database(entities = [Cake::class], version = 2)
abstract class CakeDatabase : RoomDatabase() {
    abstract fun cakeDao(): CakeDao
}