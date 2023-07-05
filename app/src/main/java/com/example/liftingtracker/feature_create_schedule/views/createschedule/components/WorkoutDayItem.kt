package com.example.liftingtracker.feature_create_schedule.views.createschedule.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.liftingtracker.workout.models.WorkoutDay

@Composable
fun WorkoutDayItem(
    item: WorkoutDay,
    elevation: CardElevation = CardDefaults.elevatedCardElevation(),
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
        ,
        elevation = elevation,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
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
                style = MaterialTheme.typography.labelSmall,
            )

            Text(
                text = item.dayNum.toString(),
                style = MaterialTheme.typography.labelSmall
            )


        }
    }
}

@Preview
@Composable
fun WorkoutDayPreview() {
    val item = WorkoutDay(
        dayNum = 2,
        workoutPlanId = 0,
        title = "Back and Shoulders",
        isRest = true,
        id = "123"
    )
    WorkoutDayItem(item = item)
}