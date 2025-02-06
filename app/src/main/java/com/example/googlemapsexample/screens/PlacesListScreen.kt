package com.example.googlemapsexample.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.googlemapsexample.viewmodel.PlaceViewModel

@Composable
fun PlacesListScreen(viewModel: PlaceViewModel) {
    val places by viewModel.places.collectAsState(initial = emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(places) { place ->
            Text(text = "${place.address} (${place.latitude}, ${place.longitude})")
        }
    }
}