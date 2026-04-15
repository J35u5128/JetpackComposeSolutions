package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Arriba")
        HorizontalDivider()
        Text("Abajo")
    }
    Row{
        Text("Izquierda")
        VerticalDivider()
        Text("Derecha")
    }
}