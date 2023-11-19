package com.example.travelmore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ResultsBox(
    modifier: Modifier = Modifier,


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
