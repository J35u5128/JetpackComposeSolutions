package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jalcalap.jetpackcomposesolutions.R
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {
    val names = listOf("aris", "jesus", "rambo")
    LazyRow {
        items(names, key = { it }) {
            Text(
                it, modifier = Modifier
                    .padding(24.dp)
                    .clickable { onItemClick(it) })
        }
    }
}

@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    var items by remember { mutableStateOf(List(100) { "Item numero $it" }) }
    LazyColumn() {
        item {
            Button({
                items = items.toMutableList().apply { add(0, "Hola") }
            }) { Text("Añadir item") }
        }
        itemsIndexed(items, key = { _, item -> item }) { index, item ->
            Row {
                Text(item + "indice:$index")
                Spacer(Modifier.weight(1f))
                TextButton({
                    items = items.toMutableList().apply {
                        remove(item)
                        //removeAt(index)
                    }
                }) { Text("Borrar") }
                Spacer(Modifier.width(24.dp))
            }
        }
    }
}

@Composable
fun ScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val showButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 5 }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        LazyColumn(state = listState) {
            items(100) {
                Text("Item: $it")
            }
        }
        if (showButton) {
            FloatingActionButton(onClick = {
                coroutineScope.launch { listState.animateScrollToItem(0) }
            }) {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numbers = remember { mutableStateOf(List(50){ Random.nextInt(0,6) }) }
    val colors = listOf(
        Color(0xFFE57373),
        Color(0xFFFFB74D),
        Color(0xFFFFF176),
        Color(0xFF81C784),
        Color(0xFF64B5F6),
        Color(0xFFBA68C8)
    )
    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp),
        // en horizontal grid: rows = GridCells.Fixed(4),
        modifier = Modifier.fillMaxSize().padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(numbers.value){randomNumber ->
            Box(
                modifier = Modifier.background(colors[randomNumber]).height(80.dp),
                contentAlignment = Alignment.Center
                ){
                Text(randomNumber.toString(), color = Color.White, fontSize = 28.sp)
            }
        }
    }
}