package com.jalcalap.jetpackcomposesolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jalcalap.jetpackcomposesolutions.components.MyCard
import com.jalcalap.jetpackcomposesolutions.components.MyModalDrawer
import com.jalcalap.jetpackcomposesolutions.components.MyOutlinedCard
import com.jalcalap.jetpackcomposesolutions.ui.theme.JetpackComposeSolutionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeSolutionsTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                remember { SnackbarHostState() }
                rememberCoroutineScope()

                MyModalDrawer(drawerState) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        MyOutlinedCard(Modifier.padding(innerPadding))
                    }
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeSolutionsTheme {
        Greeting("Android")
    }
}