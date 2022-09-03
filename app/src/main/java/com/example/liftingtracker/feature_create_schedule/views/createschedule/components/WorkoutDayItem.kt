package com.example.liftingtracker.feature_create_schedule.views.createschedule.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay

@ExperimentalMaterialApi
@Composable
fun WorkoutDayItem(
    item: WorkoutDay,
    elevation: Dp,
    onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
        ,
        elevation = elevation,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        onClick = onClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.h6,
            )

            Text(
                text = item.dayNum.toString(),
                style = MaterialTheme.typography.h5
            )


        }
    }
}

@Preview
@ExperimentalMaterialApi
@Composable
fun WorkoutDayPreview() {
    val item = WorkoutDay(
        dayNum = 2,
        workoutPlanId = 0,
        title = "Back and Shoulders",
        isRest = true,
        id = "123"
    )
    WorkoutDayItem(item = item, 2.dp) {
    }
}