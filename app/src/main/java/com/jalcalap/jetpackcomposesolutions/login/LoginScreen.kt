package com.jalcalap.jetpackcomposesolutions.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun Sample(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello world en una login screen :)!",
        modifier = modifier
    )
}

@Preview()

@Composable
fun samplePreview(){
    sample("AAAA")
}

@Composable
fun sample(a:String = ":v"){
    Text("Texto de ejemplo: $a",modifier = Modifier
        .background(Color.Green)
        .padding(all = 30.dp)
        .clickable{}
    )
}

@Preview
@Composable
fun sample2(){
    Text("Texto de ejemplo otra vez")
}

@Preview
@Composable
fun sample3(){
    Text("Texto de ejemplo y otra mas")
}