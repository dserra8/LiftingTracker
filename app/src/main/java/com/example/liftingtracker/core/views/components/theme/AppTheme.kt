package com.example.liftingtracker.core.views

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.liftingtracker.core.util.ThemeColors.DarkColors
import com.example.liftingtracker.core.util.ThemeColors.LightColors


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if(darkTheme) DarkColors else LightColors,
        content = content,
    )
}