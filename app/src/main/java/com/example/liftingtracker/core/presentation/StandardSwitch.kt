package com.example.liftingtracker.core.presentation

import androidx.compose.material.Switch
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StandardSwitch(state: Boolean, onClick: (Boolean) -> Unit) {
    Switch(
        checked = state,
        onCheckedChange = onClick
    )
}

@Preview
@Composable
fun PreviewSwitch() {
    var state by remember{ mutableStateOf(true) }
    StandardSwitch(state = state, onClick = {state = it})
}