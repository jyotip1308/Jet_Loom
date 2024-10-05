package com.android.jetloom.authScreens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jetloom.R
import com.android.jetloom.ui.theme.blue
import kotlinx.coroutines.delay

@Preview
@Composable
fun Splash(){

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
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
    }

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.background(color = blue).fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.jetloom),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
                .size(width = 190.dp, height = 100.dp))
    }

}