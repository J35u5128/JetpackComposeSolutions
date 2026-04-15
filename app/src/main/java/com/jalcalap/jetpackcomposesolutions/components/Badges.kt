package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.jalcalap.jetpackcomposesolutions.R

@Preview
@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge(
        contentColor = Color.Blue,
        containerColor = Color.Green
    ) {
        Text("3")
    }
}

@Preview
@Composable
private fun MyBadgeBox(modifier: Modifier = Modifier) {
    BadgedBox(badge = {MyBadge()}) {
        Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)
    }
}