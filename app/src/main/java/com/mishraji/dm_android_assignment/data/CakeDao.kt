package com.mishraji.dm_android_assignment.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CakeDao {
    @Query("SELECT * FROM cake")
    fun getAllCake(): Flow<List<Cake>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCake(cake: List<Cake>)

    @Query("DELETE FROM cake")
    suspend fun deleteAllCake()
}