package com.mrkevin574.pomodoro.presentation.screens.timer.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.presentation.Event

@Composable
fun ButtonsTimer(onClick : (Event) -> Unit, isPlay : Boolean, colorButtons : Color) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 50.dp, end = 50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
    ){
        OptionImage(imageVector = Icons.Rounded.Stop, stringResource(R.string.stop), colorButtons = colorButtons) { onClick(Event.Stop) }
        if(!isPlay)
            OptionImage(imageVector = Icons.Rounded.PlayArrow, stringResource(R.string.play),colorButtons = colorButtons) { onClick(Event.Resume) }
        else
            OptionImage(imageVector = Icons.Filled.Pause, stringResource(R.string.resume),colorButtons = colorButtons) { onClick(Event.Pause) }
        OptionImage(imageVector = Icons.Rounded.SkipNext, stringResource(R.string.next),colorButtons = colorButtons) { onClick(Event.Next) }
    }
}

@Composable
fun OptionImage(imageVector: ImageVector, contentDescription : String, colorButtons: Color, onClick: () -> Unit)
{
    Image(
        imageVector = imageVector,
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(colorButtons),
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .clickable { onClick() },
    )
}