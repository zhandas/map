package com.example.googlemapsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.googlemapsexample.database.AppDatabase
import com.example.googlemapsexample.ui.NavigationScreen
import com.example.googlemapsexample.ui.theme.GoogleMapsExampleTheme
import com.example.googlemapsexample.utils.Graph
import com.example.googlemapsexample.viewmodel.LocationViewModel
import com.example.googlemapsexample.viewmodel.PlaceViewModel
import com.example.googlemapsexample.viewmodel.Repository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleMapsExampleTheme {
                val repository = Repository(Graph.appDatabase!!.getPlaceDao())
                val placesViewModel: PlaceViewModel = ViewModelProvider.create(
                    this@MainActivity as ViewModelStoreOwner,
                    factory = PlaceViewModel.factory,
                    extras = MutableCreationExtras().apply {
                        set(PlaceViewModel.REPOSITORY, repository)
                        set(PlaceViewModel.APPLICATION, application)
                    }
                )[PlaceViewModel::class]
                val locationViewModel: LocationViewModel = viewModel()
                NavigationScreen(placesViewModel, locationViewModel)
            }
        }
    }
}