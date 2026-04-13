package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun MyTexts(modifier: Modifier){
    Column(modifier){
        Text("Pepe", modifier)
        Text("pepe rojo", color = Color.Red)
        Text("Pepe", fontSize = 25.sp)
    }
}