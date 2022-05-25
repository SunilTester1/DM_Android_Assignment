package com.mishraji.dm_android_assignment.data

import androidx.room.withTransaction
import com.mishraji.dm_android_assignment.api.CakeApi
import com.mishraji.dm_android_assignment.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class CakeRepository @Inject constructor (
    private val api: CakeApi,
    private val db : CakeDatabase
        ) {
    private val cakeDao = db.cakeDao()

    fun getCake() = networkBoundResource(
        query ={
            cakeDao.getAllCake()
        },
        fetch = {
            delay(2000)
            api.getCake()
        },
        saveFetchResult = {
            cake ->
            db.withTransaction {
                cakeDao.deleteAllCake()
                cakeDao.insertCake(cake)
            }
        }
    )
}