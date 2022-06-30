package com.mrkevin574.pomodoro.presentation.screens.timer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
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
fun ButtonsTimer(onClick : (Event) -> Unit, isPlay : Boolean) {
    Row(
        modifier = Modifier.fillMaxSize()
            .padding(start = 50.dp, end = 50.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
    ){
        OptionImage(imageVector = Icons.Rounded.Stop, stringResource(R.string.stop)) { onClick(Event.Stop) }
        if(!isPlay)
            OptionImage(imageVector = Icons.Rounded.PlayArrow, stringResource(R.string.play)) { onClick(Event.Play) }
        else
            OptionImage(imageVector = Icons.Rounded.Replay, stringResource(R.string.resume)) { onClick(Event.Pause) }
        OptionImage(imageVector = Icons.Rounded.SkipNext, stringResource(R.string.next)) { onClick(Event.Next) }
    }
}

@Composable
fun OptionImage(imageVector: ImageVector, contentDescription : String, onClick: () -> Unit)
{
    Image(
        imageVector = imageVector,
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(Color.White),
        modifier = Modifier
            .height(40.dp)
            .width(40.dp)
            .clickable { onClick() },
    )
}