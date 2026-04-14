package com.jalcalap.jetpackcomposesolutions.components.layouts

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jalcalap.jetpackcomposesolutions.R

@Preview
@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Avatar Image Profile",
        modifier = Modifier
            .size(300.dp)
            .clip(RoundedCornerShape(topEnd = 50.dp, bottomStart = 70.dp))
            .border(
                5.dp,
                color = Color.Red,
                shape = RoundedCornerShape(
                    topEnd = 50.dp,
                    bottomStart = 70.dp
                    /*brush = Brush.linearGradient()*/
                )
            ),
        contentScale = ContentScale.FillBounds
    )
}
@Composable
fun MyNetworkImage() {
    AsyncImage(
        model ="https://th.bing.com/th/id/OIP.fd8TcoKxV_p6xYWlSNwh-QHaHA?w=176&h=180&c=7&r=0&o=7&pid=1.7&rm=3",
        contentDescription = "Image from network",
        modifier = Modifier.size(250.dp),
        onError = {
            Log.i("Image", "Ha ocurrido un error ${it.result.throwable.message}")
        }
    )
}

@Preview
@Composable
private fun MyIcon() {
    Icon(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier = Modifier.size(300.dp),
        tint = Color.Blue
    )
}
