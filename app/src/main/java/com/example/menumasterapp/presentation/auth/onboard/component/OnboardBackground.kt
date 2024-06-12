package com.example.menumasterapp.presentation.auth.onboard.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OnboardBackground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawCircle(
            color = Color(0xFFE8ECE0),
            radius = 120f,
            center = Offset.Zero.copy(y = this.size.height / 1.8f)
        )
        drawCircle(
            color = Color(0xFF3A3A63),
            radius = 120f,
            center = Offset.Zero.copy(y = this.size.height / 1.76f),
            style = Stroke(width = 5f)
        )
        drawCircle(
            color = Color(0xFFFFE3D2),
            radius = 80f,
            center = Offset(x = this.size.width - 100f, y = this.size.height / 3)
        )
        drawCircle(
            color = Color(0xFFEE714A),
            radius = 80f,
            center = Offset(x = this.size.width - 100f, y = this.size.height / 2.95f),
            style = Stroke(width = 5f)
        )
        drawCircle(
            color = Color(0xFFFFC977),
            radius = 40f,
            center = Offset(x = this.size.width / 4, y = this.size.height / 3.6f)
        )
        drawCircle(
            color = Color(0xFFEE714A),
            radius = 40f,
            center = Offset(x = this.size.width / 4, y = this.size.height / 3.54f),
            style = Stroke(width = 5f)
        )
        drawCircle(
            color = Color(0xFFBACDE5),
            radius = 60f,
            center = Offset.Zero.copy(y = this.size.height / 4)
        )
        drawCircle(
            color = Color(0xFF3A3A63),
            radius = 60f,
            center = Offset.Zero.copy(y = this.size.height / 3.94f),
            style = Stroke(width = 5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    OnboardBackground()
}