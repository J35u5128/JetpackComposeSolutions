package com.jalcalap.jetpackcomposesolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jalcalap.jetpackcomposesolutions.components.MyFAB
import com.jalcalap.jetpackcomposesolutions.components.MyModalDrawer
import com.jalcalap.jetpackcomposesolutions.components.MyNavigationBar
import com.jalcalap.jetpackcomposesolutions.components.MyTopAppBar
import com.jalcalap.jetpackcomposesolutions.ui.theme.JetpackComposeSolutionsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeSolutionsTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                MyModalDrawer(drawerState) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar{scope.launch { drawerState.open() }} },
                        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                        floatingActionButton = { MyFAB() },
                        floatingActionButtonPosition = FabPosition.Start,
                        bottomBar = { MyNavigationBar() }
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(Color.Cyan),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Esta es mi screen", modifier = Modifier.clickable {
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "ejemplo",
                                        actionLabel = "Deshacer"
                                    )
                                    if (result == SnackbarResult.ActionPerformed) {
                                        //deshacer
                                    } else {
                                        //!deshacer
                                    }
                                }
                            })
                        }
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