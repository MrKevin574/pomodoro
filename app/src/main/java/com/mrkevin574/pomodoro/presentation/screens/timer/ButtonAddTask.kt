package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
        imageVector = Icons.Filled.Add,
        contentDescription = stringResource(R.string.add_task),
        colorFilter = ColorFilter.tint(Color.White),
        modifier = Modifier
            .padding(top = 50.dp)
            .width(55.dp)
            .height(55.dp)
    )


}