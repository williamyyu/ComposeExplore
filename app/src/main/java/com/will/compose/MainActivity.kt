package com.will.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
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
            var checkState by remember {
                mutableStateOf(false)
            }

            NameItem(name = it, checkState = checkState) { isChecked ->
                checkState = isChecked
            }
            Divider()
        }
    }
}

@Composable
fun NameItem(name: String, checkState: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row {
        Checkbox(
            checked = checkState,
            onCheckedChange = { checked ->
                onCheckedChange(checked)
            }, modifier = Modifier.align(Alignment.CenterVertically)
        )
        Greeting(name)
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
    var isSelected by remember {
        mutableStateOf(false)
    }

    val targetColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.primary else Color.Transparent,
        animationSpec = tween(durationMillis = 1500)
    )

    Surface(color = targetColor) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .background(targetColor)
                .padding(16.dp)
                .clickable {
                    isSelected = !isSelected
                }
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}

@Preview(showBackground = true)
@Composable
fun NameItemPreview() {
    Column {
        NameItem(name = "This is unchecked", checkState = false, onCheckedChange = {})
        NameItem(name = "This is checked", checkState = true, onCheckedChange = {})
    }
}