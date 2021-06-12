package com.will.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scaffold Example")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Favorite, null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp)
        )
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Hello")
        Text(text = "This is body")
    }
}


@Preview(showBackground = true)
@Composable
fun ScaffoldExamplePreview() {
    ScaffoldExample()
}