package com.example.googlemapsexample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.googlemapsexample.screens.MainScreen
import com.example.googlemapsexample.screens.MapScreen
import com.example.googlemapsexample.screens.PlacesListScreen
import com.example.googlemapsexample.utils.Graph
import com.example.googlemapsexample.utils.LocationUtils
import com.example.googlemapsexample.viewmodel.LocationViewModel
import com.example.googlemapsexample.viewmodel.PlaceViewModel

@Composable
fun NavigationScreen(viewModel: PlaceViewModel, locationViewModel: LocationViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val locationUtils = remember { LocationUtils(context, locationViewModel)}

    NavHost(navController, startDestination = Graph.MAIN_SCREEN) {
        composable(Graph.MAIN_SCREEN) {
            MainScreen(
                context = context,
                locationUtils = locationUtils,
                viewModel = locationViewModel,
                navHostController = navController
            )
        }
        composable("places_list") {
            PlacesListScreen(viewModel)
        }
        composable("map/{placeId}") { backStackEntry ->
            val placeId = backStackEntry.arguments?.getString("placeId")?.toLongOrNull()
            val place = viewModel.getPlaceById(placeId ?: 0) // Получите место по ID
            MapScreen(place)
        }
    }
}