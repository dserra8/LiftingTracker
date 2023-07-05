package com.example.liftingtracker.core.views.components.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp


val LocalBonesSpacings = staticCompositionLocalOf {
    BonesSpacings()
}

@Immutable
class BonesSpacings {
    @Composable
    fun Spacing(size: Dp) {
        Spacer(modifier = Modifier.size(size))
    }

    @Composable
    fun Spacing2() = Spacing(Bones.Dimension.Palette.Dimen2)

    @Composable
    fun Spacing4() = Spacing(Bones.Dimension.Palette.Dimen4)

    @Composable
    fun Spacing8() = Spacing(Bones.Dimension.Palette.Dimen8)

    @Composable
    fun Spacing12() = Spacing(Bones.Dimension.Palette.Dimen12)

    @Composable
    fun Spacing16() = Spacing(Bones.Dimension.Palette.Dimen16)

    @Composable
    fun Spacing20() = Spacing(Bones.Dimension.Palette.Dimen20)

    @Composable
    fun Spacing24() = Spacing(Bones.Dimension.Palette.Dimen24)

    @Composable
    fun Spacing32() = Spacing(Bones.Dimension.Palette.Dimen32)

    @Composable
    fun Spacing40() = Spacing(Bones.Dimension.Palette.Dimen40)

    @Composable
    fun Spacing48() = Spacing(Bones.Dimension.Palette.Dimen48)

    @Composable
    fun Spacing56() = Spacing(Bones.Dimension.Palette.Dimen56)

    @Composable
    fun Spacing64() = Spacing(Bones.Dimension.Palette.Dimen64)

    @Composable
    fun Spacing72() = Spacing(Bones.Dimension.Palette.Dimen72)

    @Composable
    fun Spacing80() = Spacing(Bones.Dimension.Palette.Dimen80)

    @Composable
    fun Spacing96() = Spacing(Bones.Dimension.Palette.Dimen96)
}
