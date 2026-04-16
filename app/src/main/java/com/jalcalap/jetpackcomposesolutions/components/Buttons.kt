package com.jalcalap.jetpackcomposesolutions.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jalcalap.jetpackcomposesolutions.R

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = { Log.i("Sample", "Boton pulsado") },
            shape = RoundedCornerShape(20),
            border = BorderStroke(4.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContainerColor = Color.Yellow,
                disabledContentColor = Color.Green
            )
        ) {
            Column() {
                Text("Pulsame", color = Color.White)
            }
            OutlinedButton(
                onClick = {}, colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text("Outlined")
            }
            TextButton(onClick = {}) {
                Text("TextButton")
            }
            ElevatedButton(onClick = {}) {
                Text("ElevatedButton")
            }
            //Este botón es igual que un botón normal, la principal diferencia es que su color es mas suave
            FilledTonalButton(onClick = {}) {}
        }
    }
}

@Preview
@Composable
fun MyFAB(modifier: Modifier = Modifier, showCombat:()-> Unit = {}) {
    FloatingActionButton(
        onClick = {showCombat()},
        shape = CircleShape,
        containerColor = Color.Red,
        contentColor = Color.White,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 12.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
    }
}