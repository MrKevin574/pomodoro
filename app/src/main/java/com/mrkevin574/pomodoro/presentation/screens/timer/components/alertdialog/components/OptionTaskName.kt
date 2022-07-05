package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.ui.theme.*

@Composable
fun OptionTaskName(onSelectName: (String) -> Unit) {
    val name = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .background(BackgroundAlertDialog)
                .height(300.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = { name.value = it },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = PrimaryTextColor,
                    focusedLabelColor = BreakColor,
                    unfocusedIndicatorColor = BreakColorSecondary
                ),
                label = {
                    Text(
                        text = stringResource(R.string.insert_name),
                        color = PrimaryTextColor
                    )
                }
            )
            ButtonNext(onClick = { onSelectName(name.value) })
        }

}