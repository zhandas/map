package com.example.googlemapsexample.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.googlemapsexample.data.Place
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(place: Place?) {
    val latLng = LatLng(place?.latitude ?: 0.0, place?.longitude ?: 0.0)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(latLng, 10f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        place?.let {
            Marker(
                state = MarkerState(position = latLng),
                title = it.address
            )
        }
    }
}