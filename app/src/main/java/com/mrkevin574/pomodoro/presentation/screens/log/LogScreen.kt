package com.mrkevin574.pomodoro.presentation.screens.log

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ManageSearch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.presentation.screens.timer.TimerViewModel
import com.mrkevin574.pomodoro.ui.theme.oswaldMedium

@Composable
fun LogScreen(
    viewModel: TimerViewModel = hiltViewModel()
) {

    val pomodoroList = viewModel.pomodoroList.value

    if(!pomodoroList.isEmpty())
    {
        LazyColumn(modifier = Modifier.fillMaxSize())
        {
            items(pomodoroList)
            {
                PomodoroItem(it, onClickDelete = {viewModel.deletePomodoro(it)})
            }
        }
    }else{
        TextNotTaskSaved()
    }

}

@Composable
fun TextNotTaskSaved() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Image(imageVector = Icons.Outlined.ManageSearch,
            contentDescription = "Not task",
            modifier = Modifier.width(70.dp)
                .height(70.dp)
                .padding(bottom = 10.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Text(
            text = stringResource(R.string.not_task_saved),
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            fontFamily = oswaldMedium
        )
    }

}