package com.example.travelmore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.libraries.places.api.net.PlacesClient
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SearchBox(
    modifier: Modifier = Modifier,
    searchIcon: ImageVector = Icons.Default.Search,
    placesClient: PlacesClient // Inject the PlacesClient dependency
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(horizontal = 16.dp, vertical = 8.dp),

    ) {

        Spacer(modifier = Modifier.width(8.dp))
        BasicTextField(
            value = "",
            onValueChange = {},

            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .heightIn(min = 48.dp)
                .padding(vertical = 8.dp)
        )
    }
}
