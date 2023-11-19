package com.example.travelmore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting("Android")
                }
                SearchBox("")

            }
                Results("")
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


@Composable
    fun Results(name: String, modifier: Modifier = Modifier) {
        Surface(color = Color.Cyan) {
            Text(
                text = "Search results",
                modifier = modifier.padding(24.dp)
            )
        }
    }


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

    @Preview(showBackground = true)
    @Composable
    fun ResultsPreview() {
        TravelMoreTheme {
            Results("")
        }
    }








