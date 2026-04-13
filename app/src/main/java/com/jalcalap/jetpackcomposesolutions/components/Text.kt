package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp


@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier) {
        Text("Pepe", modifier)
        Text("pepe rojo", color = Color.Red)
        Text("Pepe", fontSize = 25.sp)
        Text("FontStyle", fontStyle = FontStyle.Italic)
        Text(
            "FontWeight",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text("LetterSpacing", letterSpacing = 20.sp)
        Text(
            "TextDecoration",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = Modifier.clickable {})
        Text(
            "TextDecoration",
            textDecoration = TextDecoration.LineThrough + TextDecoration.Underline
        )
    }
}