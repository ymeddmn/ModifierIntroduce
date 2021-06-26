package com.ananananzhuo.composecolumn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.ananananzhuo.composecolumn.ui.theme.ComposeColumnTheme

fun logEE(msg: String) {
    Log.e("安安安安卓", msg)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeColumnTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting4()
                }
            }
        }
//        startActivity(Intent(this,RememberActivity::class.java))
//        startActivity(Intent(this,ToggleableActivity::class.java))
    }
}

@Composable
fun Greeting4() {
    DefaultPreview4()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(1f)
    ) {


        Box {

            Text(
                text = "安安安安卓2",
                modifier = Modifier
                    .size(100.dp)
                    .background(color = Color.Red)
                    .zIndex(5f)
            )
            Text(
                text = "安安安安卓1",
                modifier = Modifier
                    .size(150.dp)
                    .background(color = Color.Green)
                    .zIndex(4f)
            )

        }
        item1(
            m = Modifier
                .background(color = Color.Red)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        item1(
            m = Modifier
                .background(color = Color.Red)
                .widthIn(min = 50.dp, max = 200.dp)
        )

        item1(
            m = Modifier
                .background(color = Color.Red)
                .shadow(elevation = 3.dp, shape = RectangleShape, clip = true)//不知道是否是我用的不对，效果非常不好看
        )

        item1(
            m = Modifier
                .background(color = Color.Red)
                .scale(2f)
        )
        item1(
            m = Modifier
                .background(color = Color.Red)
                .requiredWidth(300.dp)
        )
        item1(
            m = Modifier
                .background(color = Color.Red)
                .requiredHeight(height = 20.dp)
        )
        item1(
            m = Modifier
                .background(color = Color.Red)
                .layoutId("name")
        )
        Text(
            text = "公众号，安安安安卓，是一个用来分享安卓知识的公众号，ad发法撒扥a懂法A栋发扥as扥公众号，安安安安卓，是一个用来分享安卓知识的公众号，ad发法撒扥a懂法A栋公众号，安安安安卓，是一个用来分享安卓知识的公众号，ad发法撒扥a懂法A栋公众号，安安安安卓，是一个用来分享安卓知识的公众号，ad发法撒扥a懂法A栋公众号，安安安安卓，是一个用来分享安卓知识的公众号，ad发法撒扥a懂法A栋公众号，安安安安卓，是一个用来分享安卓知识的公众号，ad发法撒扥a懂法A栋",
            modifier = Modifier
                .horizontalScroll(enabled = true, state = ScrollState(12))
                .height(100.dp)
                .background(color = Color.Green),
            textAlign = TextAlign.Center
        )

        item1(
            m = Modifier
                .background(color = Color.Red)
                .defaultMinSize(300.dp)
        )
        item1(
            m = Modifier
                .background(color = Color.Red)
                .clickable(onClick = {
                    Log.e("tag", "安安安安卓")
                })
        )

        item1(
            m = Modifier
                .background(color = Color.Red)
                .alpha(0.3f)
        )
        item1(
            m = Modifier
                .background(color = Color.Red)
                .absoluteOffset(x = 30.dp)
        )
        item1(
            m = Modifier
                .background(color = Color.Red)
                .offset(x = 30.dp)
        )

        Box(modifier = Modifier.fillMaxWidth(1f)) {
            Box(modifier = Modifier.clipToBounds()) {
                Box(
                    Modifier
                        .size(200.dp)
                        .background(color = Color.Green)
                )
            }
        }

        Box(modifier = Modifier.clip(CircleShape)) {
            Box(
                Modifier
                    .size(200.dp)
                    .background(color = Color.Green)
            )
        }
        item1(
            m = Modifier
                .background(color = Color.Red, shape = CircleShape)
                .padding(4.dp)
                .border(border = BorderStroke(2.dp, color = Color.Green), shape = CircleShape)
        )
        item1(
            m = Modifier.background(
                brush = Brush.linearGradient(
                    mutableListOf(
                        Color.Red,
                        Color.Green,
                        Color.Yellow,
                        Color.Gray
                    )
                )
            )
        )
        item1(m = Modifier.background(color = Color.Red, shape = RoundedCornerShape(20.dp)))
        item1(m = Modifier.background(color = Color.Red, shape = CircleShape))
        item1(m = Modifier.background(color = Color.Red))
        item1(
            m = Modifier
                .background(color = Color.Blue)
                .size(30.dp)
        )
        item1(
            m = Modifier
                .background(color = Color.Blue)
                .fillMaxSize(0.75f)
        )
        item1(
            m = Modifier
                .background(color = Color.Blue)
                .height(30.dp)
        )
    }
}

@Composable
fun item1(m: Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(1f),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = m.size(100.dp),
            contentAlignment = Alignment.Center

        ) {
            Text(
                text = "安安安安卓",
                textAlign = TextAlign.Center,
                style = TextStyle(color = Color.White)
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}