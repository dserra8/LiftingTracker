package com.example.liftingtracker.feature_create_schedule.views.createschedule

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.liftingtracker.R
import com.example.liftingtracker.core.views.AppTheme
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay
import com.example.liftingtracker.feature_create_schedule.views.CreateScheduleViewModel
import com.example.liftingtracker.feature_create_schedule.views.createschedule.components.BackLayer
import com.example.liftingtracker.feature_create_schedule.views.createschedule.components.FrontLayer
import com.example.liftingtracker.feature_create_schedule.views.createschedule.state.rememberCreateScheduleState
import kotlinx.coroutines.launch
import java.util.*

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun CreateScheduleScreen(
    navController: NavController,
    viewModel: CreateScheduleViewModel = viewModel()
) {
    val state = rememberCreateScheduleState(
        initialScaffoldState = BackdropValue.Revealed,
        initialDay = 0,
        initialList = mutableStateListOf(
            WorkoutDay(
                dayNum = 1,
                workoutPlanId = 0,
                id = UUID.randomUUID().toString()
            )
        )
    )

    val scope = rememberCoroutineScope()

    BackdropScaffold(
        scaffoldState = state.scaffoldState,
        appBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (state.scaffoldState.isConcealed) {
                            IconButton(
                                onClick = {
                                    scope.launch { state.scaffoldState.reveal() }
                                }
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.ic_arrow_downward),
                                    contentDescription = "Menu Icon",
                                )
                            }
                        } else {
                            IconButton(
                                onClick = {
                                    scope.launch { state.scaffoldState.conceal() }
                                }
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.ic_arrow_upward),
                                    contentDescription = "Close",
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Create Schedule",
                        )
                    }
                },
            )
        },
        backLayerContent = {
            BackLayer(
                state = state,
            )
        },
        frontLayerContent = {
            FrontLayer(
                state = state
            )
        },
    )

}


@Preview
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun CreateSchedulePreview() {
    val controller = rememberNavController()
    AppTheme() {
        CreateScheduleScreen(navController = controller)
    }
}
