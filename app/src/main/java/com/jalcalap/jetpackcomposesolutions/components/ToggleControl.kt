package com.jalcalap.jetpackcomposesolutions.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.jalcalap.jetpackcomposesolutions.R
import com.jalcalap.jetpackcomposesolutions.components.state.CheckBoxState

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState, onCheckedChange = { switchState = it }, thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = ""
                )
            },
            enabled = true,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Green,
                disabledUncheckedThumbColor = Color.Yellow,
                checkedIconColor = Color.Magenta,
                uncheckedIconColor = Color.Cyan,
                disabledCheckedIconColor = Color.White,
                disabledUncheckedIconColor = Color.Black,
                checkedBorderColor = Color.Green,
                uncheckedBorderColor = Color.Red,
                disabledCheckedBorderColor = Color.Blue,
                disabledUncheckedBorderColor = Color.Yellow,
                checkedTrackColor = Color.Gray,
                uncheckedTrackColor = Color.LightGray,
                disabledCheckedTrackColor = Color.Black,
                disabledUncheckedTrackColor = Color.White
            )
        )
    }
}

@Composable
fun MyCheckbox(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { state = !state }) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Red,
                    checkmarkColor = Color.Black,
                    disabledCheckedColor = Color.White,
                    disabledUncheckedColor = Color.Black,
                    //disabledIndeterminateColor = Color.Gray
                )
            )
            Spacer(Modifier.width(12.dp))
            Text("Acepta los terminos y condiciones :)")
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState(
                    "terms",
                    "Aceptar los términos y condiciones :V"
                ),
                CheckBoxState(
                    "newsletter",
                    "PERIODICOOOOOOOO",
                    true
                ),
                CheckBoxState(
                    "updates",
                    "tranqui que no somos como windows :)",
                    false
                )
            )
        )
    }
    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable { onCheckedChange(checkBoxState) }) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true,
        )
        Spacer(Modifier.width(12.dp))
        Text(checkBoxState.label)
    }
}

@Composable
fun TristateChackBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState.Off) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }
    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text("Select all")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child1, onCheckedChange = { child1 = it })
            Text("Sample 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child2, onCheckedChange = { child2 = it })
            Text("Sample 2")
        }
    }
}

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            modifier = modifier,
            selected = state,
            onClick = { state = true },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Red,
                disabledSelectedColor = Color.Black,
                disabledUnselectedColor = Color.White
            )
        )
    }
}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedname by remember { mutableStateOf("") }
    Column(modifier = modifier) {
        RadioButtonComponent(name = "Sample", selectedname = selectedname) { selectedname = it }
        RadioButtonComponent(name = "Sample2", selectedname = selectedname) { selectedname = it }
        RadioButtonComponent(name = "Sample3", selectedname = selectedname) { selectedname = it }
        RadioButtonComponent(name = "Sample4", selectedname = selectedname) { selectedname = it }
        RadioButtonComponent(name = "Sample5", selectedname = selectedname) { selectedname = it }
        RadioButtonComponent(name = "Sample6", selectedname = selectedname) { selectedname = it }
    }
}

@Composable
fun RadioButtonComponent(name: String, selectedname: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = name == selectedname, onClick = { onItemSelected(name) })
        Text(name, modifier = Modifier.clickable { onItemSelected(name) })
    }
}