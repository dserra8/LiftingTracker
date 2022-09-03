package com.example.liftingtracker.core.views

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme

import androidx.compose.runtime.Composable
import com.example.liftingtracker.core.util.ThemeColors.darkColors
import com.example.liftingtracker.core.util.ThemeColors.lightColors

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if(darkTheme) darkColors else lightColors,
        content = content
    )
}