package com.example.travelmore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travelmore.model.Place
import com.example.travelmore.ui.PlacesUiState
import com.example.travelmore.ui.PlacesViewModel
import com.example.travelmore.ui.theme.TravelMoreTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelMoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Greeting("Android")

                    val placesViewModel: PlacesViewModel = viewModel()
                    PlacesApp(
                        placesUIState = placesViewModel.placesUiState,
                    )
                }
                Greeting("Android")
                SearchBox("")

            }
                // Results("")

        }

    }
}

@Composable
fun PlacesApp(placesUIState: PlacesUiState
) {
    when (placesUIState) {
        is PlacesUiState.Success -> {
            PlacesList(placesUIState.places)
        }
        is PlacesUiState.Loading -> {
            // TODO show spinner
        }
        is PlacesUiState.Error -> {
            // TODO add error to logs
        }
    }
}

@Composable
fun PlacesList(placesList: List<Place>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(placesList) { place ->
            TravelMoreCard(place = place)
        }
    }
}

@Composable
fun TravelMoreCard(place: Place, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(4.dp)) {
        Column {
            Text(
                text = place.name,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineLarge
            )
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier.fillMaxSize()
            ) {
                Text(
                    text = stringResource(R.string.rating) + place.rating.toString(),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = if (place.openingHours?.openNow == true) {
                        stringResource(R.string.open_now)
                    } else {
                        stringResource(
                            R.string.closed
                        )
                    },
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

 @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Surface(color = Color.Cyan) {
            Text(
                text = "Welcome to City Safari $name!",
                modifier = modifier.padding(24.dp)
            )
        }
    }

@Composable
fun SearchBox(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Where do you want to go?",
            modifier = modifier.padding(24.dp)
        )
    }
}


/*@Composable
    fun Results(name: String, modifier: Modifier = Modifier) {
        Surface(color = Color.Cyan) {
            Text(
                text = "Search results",
                modifier = modifier.padding(24.dp)
            )
        }
    }
*/

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        TravelMoreTheme {
            Greeting("")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SearchPreview() {
        TravelMoreTheme {
            // Preview your SearchBox composable
            SearchBox(
                modifier = Modifier.padding(8.dp)

            )
        }
    }

    /* @Preview(showBackground = true)
    @Composable
    fun ResultsPreview() {
        TravelMoreTheme {
            Results("")
        }
    }
    */






