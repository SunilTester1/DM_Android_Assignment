package com.mishraji.dm_android_assignment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cake")
data class Cake(
    @PrimaryKey
    var id: String,
    var type: String?,
    var name: String?,
    var topping : List<Topping> = emptyList()
)