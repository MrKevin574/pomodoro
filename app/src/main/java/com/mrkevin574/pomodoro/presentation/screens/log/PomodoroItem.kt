package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.pomodoro.data.local.PomodoroEntity
import com.mrkevin574.pomodoro.ui.theme.oswaldMedium

@Composable
fun PomodoroItem(pomodoro: PomodoroEntity, onClickDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 30.dp, end = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = pomodoro.name.replaceFirstChar { it.uppercase() },
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            TextSecondaryTask("Date created: ${pomodoro.date}")
            TextSecondaryTask("Cycles completed: ${pomodoro.cycles}")
            TextSecondaryTask("Total focused time: ${pomodoro.focusedTime} minutes")
        }
        Image(
            imageVector = Icons.Filled.Delete,
            contentDescription = "Delete",
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .clickable { onClickDelete() },
            colorFilter = ColorFilter.tint(Color.White)
        )
    }

}

@Composable
fun TextSecondaryTask(text: String) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        color = Color.White,
        fontFamily = oswaldMedium
    )
}