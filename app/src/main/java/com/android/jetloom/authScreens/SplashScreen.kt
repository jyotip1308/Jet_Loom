package com.android.jetloom.authScreens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.jetloom.R
import com.android.jetloom.ui.theme.blue
import kotlinx.coroutines.delay

@Preview
@Composable
fun Splash(){

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // List of random texts to display
    val texts = listOf("Welcome", "Loading...", "Get Ready", "Almost There", "Hello Jet Loom")
    var currentTextIndex by remember { mutableIntStateOf(0) }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1.6f,
            animationSpec = tween(
                durationMillis = 3000,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(3000L)
//        mNavigator.navigateTo(Screens.Register.route)

        // Changing the text every 2 seconds
        while (true) {
            delay(1000L)
            currentTextIndex = (currentTextIndex + 1) % texts.size // Move to the next text
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image with scale animation
        Image(
            painter = painterResource(id = R.drawable.jetloom),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .size(width = 190.dp, height = 100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Text that changes randomly
        Text(
            text = texts[currentTextIndex],
            color = Color.White,
            style = TextStyle(fontSize = 24.sp)
        )
    }
}