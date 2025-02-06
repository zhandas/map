package com.example.googlemapsexample.viewmodel

import androidx.room.Delete
import androidx.room.Query
import com.example.googlemapsexample.data.Place
import com.example.googlemapsexample.data.PlaceDao

class Repository (
    private val placeDao: PlaceDao)
{
suspend fun insert(place: Place) {
    placeDao.insert(place)
}

}
