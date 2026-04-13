package com.jalcalap.jetpackcomposesolutions.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyEj1(modifier: Modifier) {
    Column() {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Cyan),
            contentAlignment = Alignment.Center) {
            Text("Ejemplo 1")
        }
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Green)) {
            Row() {
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                    contentAlignment = Alignment.Center) {
                    Text("Ejemplo 2")
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Ejemplo 3")
                }
            }
        }
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Magenta),
            contentAlignment = Alignment.Center)
        {
            Text("Ejemplo 4")
        }
    }
}