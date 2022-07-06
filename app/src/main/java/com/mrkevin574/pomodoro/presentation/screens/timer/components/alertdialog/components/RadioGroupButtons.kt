package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mrkevin574.pomodoro.ui.theme.*

@Composable
fun RadioGroupButtons(listButtons : List<String>, label: String, onOptionSelect: (String) -> Unit) {
    val selectedButton = remember { mutableStateOf(listButtons.first()) }
    Column(
        modifier = Modifier.fillMaxSize().background(BackgroundAlertDialog),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = label,
            color = PrimaryTextColor,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontFamily = oswaldMedium
        )
        listButtons.forEach {
            val isSelected = it == selectedButton.value
            DefaultRadioButton(
                label = it,
                isSelected = isSelected,
                onClick = {selectedButton.value = it}
            )
        }
        ButtonNext(onClick = {onOptionSelect(selectedButton.value)})
    }
}

@Composable
fun DefaultRadioButton(label : String, isSelected : Boolean, onClick : () -> Unit) {
    val colors = RadioButtonDefaults.colors(
        selectedColor = BreakColor,
        unselectedColor = PrimaryColor,
        disabledColor = Color.LightGray
    )
    Row {
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = colors
        )
        Text(
            text = label,
            color = PrimaryTextColor
        )
    }
}