package com.mrkevin574.pomodoro.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mrkevin574.pomodoro.R


val gantariFontFamily = FontFamily(
    Font(R.font.gantari_black, FontWeight.Black),
    Font(R.font.gantari_bold, FontWeight.Bold),
    Font(R.font.gantari_extra_bold, FontWeight.ExtraBold),
    Font(R.font.gantari_extra_light, FontWeight.ExtraLight),
    Font(R.font.gantari_light, FontWeight.Light),
    Font(R.font.gantari_medium, FontWeight.Medium),
    Font(R.font.gantari_semi_bold, FontWeight.SemiBold),
    Font(R.font.gantari_thin, FontWeight.Thin),
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = gantariFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)