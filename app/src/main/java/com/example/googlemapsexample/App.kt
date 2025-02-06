package com.example.googlemapsexample

import android.app.Application
import androidx.room.Room
import com.example.googlemapsexample.database.AppDatabase
import com.example.googlemapsexample.utils.Graph

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        var database = Room.databaseBuilder(this, AppDatabase::class.java, "app.db").build()
        Graph.provide(database)
    }
}