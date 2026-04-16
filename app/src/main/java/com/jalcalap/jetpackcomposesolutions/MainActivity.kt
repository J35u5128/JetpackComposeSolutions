package com.jalcalap.jetpackcomposesolutions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jalcalap.jetpackcomposesolutions.components.MyCustomDialog
import com.jalcalap.jetpackcomposesolutions.components.MyFAB
import com.jalcalap.jetpackcomposesolutions.components.MyModalDrawer
import com.jalcalap.jetpackcomposesolutions.components.MyNavigationBar
import com.jalcalap.jetpackcomposesolutions.components.MyTopAppBar
import com.jalcalap.jetpackcomposesolutions.components.model.PokemonCombat
import com.jalcalap.jetpackcomposesolutions.components.navigation.NavigationWrapper
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
                var showDialog by remember { mutableStateOf(false) }
                val pokemonCombat = PokemonCombat(pokemonA = "Pikachu", pokemonB = "Gengar")
                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onStartCombat = {
                        //Iniciar el combate
                        showDialog = false
                    },
                    onDismissDialog = { showDialog = false })

               // MyModalDrawer(drawerState) {
               //     Scaffold(
               //         modifier = Modifier.fillMaxSize(),
               //         topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
               //         snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
               //         floatingActionButton = { MyFAB { showDialog = true } },
               //         floatingActionButtonPosition = FabPosition.Center,
               //         bottomBar = { MyNavigationBar() }
               //     ) { innerPadding ->
               //         Box(
               //             modifier = Modifier
               //                 .fillMaxSize()
               //                 .padding(innerPadding)
               //                 .background(Color.Cyan),
               //             contentAlignment = Alignment.Center
               //         ) {
                            //Text("esta screen es fea", modifier = Modifier.clickable{scope.launch{
                            //  val result = snackbarHostState.showSnackbar(
                            //    message = "Ejemplo", actionLabel = "Deshacer"
                            //)
                            //if (result == SnackbarResult.ActionPerformed){
                            //Deshacer
                            //}else{
                            //nada
                            //}
                            //}})
                            //InteractionSourceExample(modifier = Modifier.padding((innerPadding)))
                            //MyLaunchedEffect() { }
                            //MyDerivedStateOf()
                            //MyGridList()
                            NavigationWrapper()
               //         }
               //     }
               // }

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