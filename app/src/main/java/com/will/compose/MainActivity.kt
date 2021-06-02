package com.will.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.will.compose.ui.theme.ComposeExploreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeExploreTheme {
        content()
    }
}

@Composable
fun MyScreenContent() {

    var countState by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.fillMaxHeight()) {

        NameList(modifier = Modifier.weight(1f))

        CountableButton(countState) { newCount ->
            countState = newCount
        }
    }
}

@Composable
fun NameList(names: List<String> = List(1000) { "Hello $it" }, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(names) {
            Greeting(it)
            Divider()
        }
    }
}

@Composable
fun CountableButton(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }, modifier = Modifier.padding(top = 16.dp)) {
        Text(text = "I've been clicked $count times")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}