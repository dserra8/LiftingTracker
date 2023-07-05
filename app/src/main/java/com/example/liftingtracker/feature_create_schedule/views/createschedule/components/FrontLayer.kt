//package com.example.liftingtracker.feature_create_schedule.views.createschedule.components
//
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.Divider
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Surface
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.example.liftingtracker.R
//import com.example.liftingtracker.core.util.Dimens
//import com.example.liftingtracker.feature_create_schedule.views.createschedule.state.CreateScheduleState
//import timber.log.Timber
//
//@ExperimentalFoundationApi
//@Composable
//fun FrontLayer(
//    state: CreateScheduleState
//) {
//    Surface(Modifier.padding(16.dp)) {
//        Spacer(modifier = Modifier.height(16.dp))
//        Column(
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = if(state.day != null) "Day ${state.day!! + 1}" else "No Days",
//                fontSize = Dimens.standardTextSize
//            )
//            Column(
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.spacedBy(5.dp),
//                modifier = Modifier.fillMaxSize()
//            ) {
//                Timber.tag(TAG).d("accessing item with dayId: ${state.day}")
//                val workoutDay = state.day?.let { dayNum ->
//                    state.list[dayNum]
//                }
//
//                Text(text = "Workout Name", fontSize = Dimens.standardTextSize)
//                OutlinedTextField(
//                    value = workoutDay?.title ?: "No Days",
//                    onValueChange = {
//                        if (workoutDay != null) {
//                            state.modifyDay(
//                                workout = workoutDay.copy(
//                                    title = it
//                                )
//                            )
//                        }
//                    },
//                    modifier = Modifier.fillMaxWidth(),
//                    placeholder = { }
//                )
//
//                //Exercise Column
//                LazyColumn(
//                    modifier = Modifier.fillMaxSize(),
//                    verticalArrangement = Arrangement.spacedBy(16.dp)
//                ) {
//                    stickyHeader {
//                        Divider(color = Color.Gray, thickness = 1.dp)
//                        Text(
//                            text = "Exercises",
//                            fontSize = Dimens.standardTextSize,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(vertical = 16.dp)
//                        )
//                        Divider(color = Color.Gray, thickness = 1.dp)
//                    }
//                    item {
//                        FloatingButton(
//                            text = "Exercise",
//                            drawable = R.drawable.ic_add,
//                            contentDescription = "Add Exercise"
//                        ) {
//                            //TODO onclick
//                        }
//                    }
//                }
//
//
//            }
//        }
//
//    }
//}