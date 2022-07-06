package com.mrkevin574.pomodoro.presentation.screens.timer.components.alertdialog.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.ui.theme.BreakColor
import com.mrkevin574.pomodoro.ui.theme.oswaldMedium

@Composable
fun ButtonNext(onClick : () -> Unit)
{
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 60.dp, end = 60.dp, top = 20.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = BreakColor,
            contentColor = Color.White
        )) {
        Text(
            text = stringResource(id = R.string.next),
            fontSize = 16.sp,
            modifier = Modifier.padding(10.dp),
            fontFamily = oswaldMedium
        )
    }
}