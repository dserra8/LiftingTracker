//package com.example.liftingtracker.core.views.components
//
//import androidx.compose.animation.animateColorAsState
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.CornerSize
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Delete
//import androidx.compose.material.icons.filled.Done
//import androidx.compose.material3.Card
//import androidx.compose.material3.Icon
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun SwipeToDismissBackground(
//    dismissState: DismissState
//) {
//    val direction = dismissState.dismissDirection ?: return
//
//    val color by animateColorAsState(
//        targetValue = when (dismissState.targetValue) {
//            DismissValue.Default -> Color.LightGray
//            DismissValue.DismissedToEnd -> Color.Green
//            DismissValue.DismissedToStart -> Color.Red
//        }
//    )
//
//    val icon = when (direction) {
//        DismissDirection.StartToEnd -> Icons.Default.Done
//        DismissDirection.EndToStart -> Icons.Default.Delete
//    }
//
//    val scale by animateFloatAsState(
//        targetValue = if (dismissState.targetValue == DismissValue.Default) 0.8f else 1.2f
//    )
//
//    val alignment = when (direction) {
//        DismissDirection.StartToEnd -> Alignment.CenterStart
//        DismissDirection.EndToStart -> Alignment.CenterEnd
//    }
//
//    Card(
//        modifier = Modifier
//            .fillMaxSize()
//        ,
//        backgroundColor = color,
//        shape = RoundedCornerShape(corner = CornerSize(16.dp))
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 5.dp),
//            contentAlignment = alignment
//        ) {
//            Icon(
//                imageVector = icon,
//                contentDescription = "icon",
//                modifier = Modifier.scale(scale),
//                tint = Color.Black
//            )
//        }
//
//    }
//}