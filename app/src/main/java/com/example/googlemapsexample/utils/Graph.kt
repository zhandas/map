package com.example.googlemapsexample.utils

import com.example.googlemapsexample.database.AppDatabase
import com.example.googlemapsexample.viewmodel.Repository

object Graph {
    const val MAIN_SCREEN = "main_screen"
    const val PLACES_LIST = "places_list"
    const val MAP_SCREEN = "map_screen"

    var appDatabase: AppDatabase? = null

    fun provide(appDatabase: AppDatabase){
        this.appDatabase = appDatabase
    }
}