package com.example.googlemapsexample.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlaceDao {
    @Insert
    suspend fun insert(place: Place)

    @Query("SELECT * FROM places")
    suspend fun getAllPlaces(): List<Place>

    @Delete
    suspend fun delete(place: Place)
}