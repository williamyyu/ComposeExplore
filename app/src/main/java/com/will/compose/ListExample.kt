package com.will.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListExample() {
    LazyColumn() {
        items(List(100) { "This is item $it" }) {
            Text(text = it)
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListExamplePreview() {
    ListExample()
}