package com.mrkevin574.pomodoro.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.mrkevin574.pomodoro.presentation.screens.log.LogScreen
import com.mrkevin574.pomodoro.presentation.screens.timer.TimerScreen
import kotlinx.coroutines.launch
import com.mrkevin574.pomodoro.R
import com.mrkevin574.pomodoro.ui.theme.PrimaryColor

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val pages = listOf(
        stringResource(R.string.timer),
        stringResource(R.string.history)
    )

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->  
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        },
        modifier = Modifier.height(dimensionResource(id = R.dimen.tab_row_size))
    ) {
        pages.forEachIndexed {index, title ->
            Tab(
                text = {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold
                    )
                       },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
    HorizontalPager(
        count = pages.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = dimensionResource(id = R.dimen.tab_row_size))
            .background(PrimaryColor)
    ){ page ->
        when(page)
        {
            0 -> {
                TimerScreen()
            }
            1 -> {
                LogScreen()
            }
        }
    }
}