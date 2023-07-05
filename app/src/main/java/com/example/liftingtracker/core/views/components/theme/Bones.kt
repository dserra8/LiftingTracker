package com.example.liftingtracker.core.views.components.theme

import androidx.compose.runtime.Composable

//@Composable
//fun Bones(
//    /* ... */
//    content: @Composable () -> Unit,
//) {
//    CompositionLocalProvider {
//
//        MaterialTheme(
//            /* colors = ... */
//            content = content,
//        )
//    }
//}

// Use like: Bones.Color.Accent or Bones.Spacing.Spacing12()
object Bones {
//    val Color: BonesColors
//        @Composable
//        get() = LocalBonesColors.current
//
//    val Typography: BonesTypography
//        @Composable
//        get() = LocalBonesTypography.current
//
//    val Shape: BonesShapes
//        @Composable
//        get() = LocalBonesShapes.current

    val Spacing: BonesSpacings
        @Composable
        get() = LocalBonesSpacings.current

    val Dimension: BonesDimensions
        get() = LocalBonesDimensions

//    val Ripple: BonesRipple
//        @Composable
//        get() = LocalBonesRipple.current
}
