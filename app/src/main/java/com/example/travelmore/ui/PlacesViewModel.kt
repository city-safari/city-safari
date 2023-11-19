package com.example.travelmore.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelmore.model.Place
import com.example.travelmore.network.PlacesApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


private val location = "37.423,-122.083"
private val radius = 5000  // 5 kilometers
private val type = "bar"
private var apiKey = com.example.travelmore.BuildConfig.GOOGLE_API_KEY


sealed class PlacesUiState {
    data class Success(val places: List<Place>) : PlacesUiState()
    data class Error(val error: String) : PlacesUiState()
    object Loading : PlacesUiState()
}

class PlacesViewModel : ViewModel() {
    var placesUiState: PlacesUiState by mutableStateOf(PlacesUiState.Loading)

    init {

        viewModelScope.launch {
            placesUiState = PlacesUiState.Loading
            placesUiState = try {
                PlacesUiState.Success(
                    PlacesApi.retrofitService.getPlaces(location, radius, type, apiKey).results
                )
            } catch (e: IOException) {
                PlacesUiState.Error(e.message.toString())
            } catch (e: HttpException) {
                PlacesUiState.Error(e.message.toString())
            }
        }
    }
}