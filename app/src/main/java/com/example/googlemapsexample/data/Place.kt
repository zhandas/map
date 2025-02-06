package com.example.googlemapsexample.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class Place(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val latitude: Double,
    val longitude: Double,
    val address: String
)