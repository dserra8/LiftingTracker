package com.example.liftingtracker.core.util

import androidx.compose.material.SliderColors
import androidx.compose.material.SliderDefaults
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object ThemeColors {
    private val primaryColor = Color(0xFF212121)
    private val primaryLightColor = Color(0xFF484848)
    private val primaryDarkColor = Color(0xFF000000)
    private val primaryTextColor = Color(0Xffffffff)
    private val errorColor = Color(0xFF990000)

    val sliderColor = Color.White

    val lightColors = lightColors(
        primary = primaryColor,
        surface = primaryTextColor,
        onPrimary = primaryTextColor,
        onSurface = primaryDarkColor,
        error = errorColor,
        onError = primaryTextColor,
        primaryVariant = primaryLightColor,
        background = primaryTextColor,
        onBackground = primaryDarkColor
    )

    val darkColors = darkColors(
        primary = primaryColor,
        surface = primaryDarkColor,
        onPrimary = primaryTextColor,
        onSurface = primaryTextColor,
        error = errorColor,
        onError = primaryTextColor,
        primaryVariant = primaryDarkColor,
        background = primaryDarkColor,
        onBackground = primaryTextColor
    )
}