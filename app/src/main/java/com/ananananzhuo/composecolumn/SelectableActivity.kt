package com.ananananzhuo.composecolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ananananzhuo.composecolumn.ui.theme.ComposeColumnTheme

class RememberActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    DefaultPreview()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val icons = listOf<Triple<Int, Int, String>>(
        Triple(R.drawable.apple, R.drawable.lufeicry, "海贼王"),
        Triple(R.drawable.nameismile, R.drawable.nameicry, "娜美"),
        Triple(R.drawable.luobinsmile, R.drawable.luobincry, "罗宾")
    )
    var selectedItem = remember {
        mutableStateOf(icons[0])
    }
    Column(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = "公众号：\"安安安安卓\"，选择:",
                style = TextStyle(
                    color = Color.Black, fontSize = 15.sp
                ),
                modifier = Modifier.weight(0.7f)
            )
            Text(
                text = selectedItem.value.third,
                style = TextStyle(color = Color.Red, fontSize = 25.sp),
                modifier = Modifier.weight(0.3f)
            )
        }
        Row(
//            modifier = Modifier
//                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            icons.forEach {
                val selected = selectedItem.value == it
                Image(
                    painter = painterResource(id = if (selected) it.first else it.second),
                    contentDescription = null,
                    modifier = Modifier
                        .selectable(
                            selected = selected,
                            enabled = true,
                            role = null,
                            onClick = {
                                selectedItem.value = it
                            })
                        .size(100.dp)
                )
            }
        }
    }

}