package com.example.googlemapsexample.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.googlemapsexample.data.Place
import com.example.googlemapsexample.database.AppDatabase
import com.example.googlemapsexample.utils.Graph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlaceViewModel(repository: Repository,application: Application) : ViewModel() {
    private val placeDao = Graph.appDatabase!!.getPlaceDao()
    private val _places = MutableStateFlow<List<Place>>(listOf())
    val places = _places.asStateFlow()

    fun insertPlace(place: Place) {
        viewModelScope.launch {
            placeDao.insert(place)
            loadPlaces()
        }
    }

    fun loadPlaces() {
        viewModelScope.launch {
            _places.value = placeDao.getAllPlaces()
        }
    }

    fun getPlaceById(id: Long): Place? {
        return null
    }

    companion object {
        val REPOSITORY = object : CreationExtras.Key<Repository>{}
        val APPLICATION = object : CreationExtras.Key<Application>{}

        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = this[REPOSITORY] as Repository
                val application = this[APPLICATION] as Application
                PlaceViewModel(repository, application)
            }
        }

    }
}