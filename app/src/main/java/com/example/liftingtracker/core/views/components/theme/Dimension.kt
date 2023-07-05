package com.example.liftingtracker.core.views.components.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalBonesDimensions =
    BonesDimensions(
        Palette = BonesDimensionPalette,
        CornerRadius = CornerRadius(
            None = BonesDimensionPalette.None,
            Small = BonesDimensionPalette.Dimen4,
            Medium = BonesDimensionPalette.Dimen8,
            Large = BonesDimensionPalette.Dimen16
        )
    )

@Immutable
data class BonesDimensions(
    val Palette: BonesDimensionPalette,
    val CornerRadius: CornerRadius,
)


/**
 * Figma
 * @see [link] https://www.figma.com/file/hSQh7Pd6U8b1DyXzdxHbrW/Bones---Design-System?node-id=1190%3A444
 */
@Immutable
data class IconButtonDimensions(
    val XSmall: Dp,
    val Small: Dp,
    val Medium: Dp,
    val Large: Dp,
    val XLarge: Dp,
)

@Immutable
data class CornerRadius(
    val None: Dp,
    val Small: Dp,
    val Medium: Dp,
    val Large: Dp,
)

@Immutable
object BonesDimensionPalette {
    val None: Dp = 0.dp
    val Dimen1: Dp = 1.dp
    val Dimen2: Dp = 2.dp
    val Dimen4: Dp = 4.dp
    val Dimen6: Dp = 6.dp
    val Dimen8: Dp = 8.dp
    val Dimen12: Dp = 12.dp
    val Dimen16: Dp = 16.dp
    val Dimen18: Dp = 18.dp
    val Dimen20: Dp = 20.dp
    val Dimen24: Dp = 24.dp
    val Dimen32: Dp = 32.dp
    val Dimen36: Dp = 36.dp
    val Dimen40: Dp = 40.dp
    val Dimen48: Dp = 48.dp
    val Dimen56: Dp = 56.dp
    val Dimen64: Dp = 64.dp
    val Dimen72: Dp = 72.dp
    val Dimen80: Dp = 80.dp
    val Dimen88: Dp = 88.dp
    val Dimen96: Dp = 96.dp
    val Dimen120: Dp = 120.dp
    val Dimen128: Dp = 128.dp
}
