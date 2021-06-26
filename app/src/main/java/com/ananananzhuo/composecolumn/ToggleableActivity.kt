package com.ananananzhuo.composecolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ananananzhuo.composecolumn.ui.theme.ComposeColumnTheme

class ToggleableActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    DefaultPreview2()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    val selected = remember {
        mutableStateOf(true)
    }
    Image(
        painter = painterResource(id = if (selected.value) R.drawable.apple else R.drawable.luobinsmile),
        contentDescription = null,
        modifier = Modifier
            .toggleable(
                value = selected.value,
                enabled = true,
                role = null,
                onValueChange = {
                    selected.value = it
                })
            .size(100.dp)
    )
}