package com.example.liftingtracker.home.views.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.liftingtracker.core.views.components.StandardCard
import com.example.liftingtracker.core.views.components.theme.Bones
import com.example.liftingtracker.home.models.WorkoutLogItem
import com.example.liftingtracker.home.views.previewproviders.WorkoutCardUiStatePreviewParameter


@Composable
fun WorkoutLogCard(
    data: WorkoutLogItem,
) {
    StandardCard {
        Column(
            modifier = Modifier
                .padding(all = Bones.Dimension.Palette.Dimen16),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier,
                    text = data.title,
                    style = MaterialTheme.typography.labelSmall,
                )
                Text(
                    text = "${data.startTime.dayOfWeek().asText} ${data.startTime.dayOfMonth}",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Bones.Spacing.Spacing4()
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
//                    data.exercises.forEach { item ->
//                        Text(
//                            text = "${item.reps}x ${item.exercise.name}",
//                            style = MaterialTheme.typography.caption
//                        )
//                    }
                    Text(text = "Hello")
                }
                Text(
                    text = data.timeInMin,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WorkoutCardPreview(
    @PreviewParameter(WorkoutCardUiStatePreviewParameter::class)
    state: WorkoutLogItem
) {
    WorkoutLogCard(
        data = state
    ) 
}

