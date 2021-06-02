package com.will.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.will.compose.ui.theme.ComposeExploreTheme

class PhotoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExploreTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PhotoDetails()
                }
            }
        }
    }
}

@Composable
fun PhotoDetails() {
    val typography = MaterialTheme.typography
    Column(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = R.drawable.header),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "This is title",
            style = typography.h4,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "This is subtitle",
            style = typography.subtitle1
        )
        Text(
            text = "This is message",
            style = typography.body2
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PhotoDetailsPreview() {
    PhotoDetails()
}