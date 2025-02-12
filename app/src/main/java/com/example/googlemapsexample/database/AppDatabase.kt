package com.example.googlemapsexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.googlemapsexample.data.Place
import com.example.googlemapsexample.data.PlaceDao

@Database(
    entities = [Place::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getPlaceDao(): PlaceDao
}