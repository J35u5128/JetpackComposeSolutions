package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick:(String) -> Unit) {
    val names = listOf("aris", "jesus", "rambo")
    LazyColumn {
        items(names){
            Text(it, modifier = Modifier
                .padding(24.dp)
                .clickable{ onItemClick(it) })
        }
    }
}