package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jalcalap.jetpackcomposesolutions.R
import com.jalcalap.jetpackcomposesolutions.components.model.DrawerItem

@Composable
fun MyModalDrawer(
    drawerState: DrawerState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()
    val myItems = listOf(
        DrawerItem(
            title = "Home",
            icon = painterResource(R.drawable.ic_launcher_foreground),
            notification = 3
        ),
        DrawerItem(
            title = "Fav",
            icon = painterResource(R.drawable.ic_launcher_foreground),
            notification = 0
        ),
        DrawerItem(
            title = "Build",
            icon = painterResource(R.drawable.ic_launcher_foreground),
            notification = 9
        ),
        DrawerItem(
            title = "Call",
            icon = painterResource(R.drawable.ic_launcher_foreground),
            notification = 0
        ),
        DrawerItem(
            title = "Location",
            icon = painterResource(R.drawable.ic_launcher_foreground),
            notification = 3
        ),
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(10),
                drawerContentColor = Color.Red,
                drawerContainerColor = Color.Black,
                drawerTonalElevation = 10.dp,
            ) {
                Spacer(modifier = Modifier.height(44.dp))
                myItems.forEachIndexed { index, drawerItem ->
                    NavigationDrawerItem(
                        label = { Text(drawerItem.title) },
                        selected = selectedIndex == index,
                        onClick = {selectedIndex = index},
                        icon = { Icon(painter = drawerItem.icon, contentDescription = null) },
                        badge = {
                            if (drawerItem.notification > 0) {
                                Badge(
                                    containerColor = if(selectedIndex == index) Color.White else Color.Red,
                                    contentColor = if(selectedIndex == index) Color.Red else Color.White,
                                ) { Text(drawerItem.notification.toString()) }
                            }
                        },
                        shape = RoundedCornerShape(0),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Color.Red,
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            selectedBadgeColor = Color.Yellow,
                            unselectedContainerColor = Color.White,
                            unselectedTextColor = Color.Red,
                            unselectedBadgeColor = Color.Green,
                            unselectedIconColor = Color.Red
                        )
                    )
                }
            }
        },
        scrimColor = Color.Red.copy(alpha = 0.6f)
    ) {
        content()
    }
}