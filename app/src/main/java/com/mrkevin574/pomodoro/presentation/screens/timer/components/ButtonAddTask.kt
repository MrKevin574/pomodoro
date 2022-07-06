package com.mrkevin574.pomodoro.presentation.screens.timer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AlarmAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mrkevin574.pomodoro.R

@Composable
fun ButtonAddTask(onClick: () -> Unit) {

    Image(
        imageVector = Icons.Filled.AlarmAdd,
        contentDescription = stringResource(R.string.add_task),
        colorFilter = ColorFilter.tint(Color.White),
        modifier = Modifier
            .padding(top = 50.dp)
            .width(55.dp)
            .height(55.dp)
            .clickable { onClick() }
    )
}