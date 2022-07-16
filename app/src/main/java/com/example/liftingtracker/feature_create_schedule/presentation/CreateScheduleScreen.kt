package com.example.liftingtracker.feature_create_schedule.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.liftingtracker.R
import com.example.liftingtracker.core.presentation.AppTheme
import com.example.liftingtracker.core.presentation.StandardSwitch
import com.example.liftingtracker.core.util.Dimens
import com.example.liftingtracker.core.util.ThemeColors.sliderColor
import com.example.liftingtracker.core.util.swapList
import com.example.liftingtracker.feature_create_schedule.domain.models.WorkoutDay
import kotlinx.coroutines.launch
import androidx.compose.ui.focus.onFocusChanged as onFocusChanged

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun CreateScheduleScreen(
    navController: NavController,
    viewModel: CreateScheduleViewModel = viewModel()
) {
    val scope = rememberCoroutineScope()
    var backdropState = rememberBackdropScaffoldState(BackdropValue.Revealed)

    val list = remember { mutableStateListOf<WorkoutDay>() }
    val sliderValue: Float by viewModel.sliderState.observeAsState(1f)
    val dayNum: Int by viewModel.dayState.observeAsState(initial = 0)
    val switchState: Boolean by viewModel.switchState.observeAsState(false)

    list.swapList(viewModel.getList())

    BackdropScaffold(
        scaffoldState = backdropState,
        appBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (backdropState.isConcealed) {
                            IconButton(
                                onClick = {
                                    scope.launch { backdropState.reveal() }
                                }) {
                                Icon(
                                    painterResource(id = R.drawable.ic_add),
                                    contentDescription = "Menu Icon",
                                )
                            }
                        } else {
                            IconButton(
                                onClick = {
                                    scope.launch { backdropState.conceal() }
                                }) {
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
                viewModel = viewModel,
                list = list,
                sliderValue = sliderValue
            )
        },
        frontLayerContent = { FrontLayer(dayNum = dayNum, list = list, switchState = switchState) },
    )

}

@ExperimentalFoundationApi
@Composable
fun FrontLayer(
    viewModel: CreateScheduleViewModel = viewModel(),
    list: SnapshotStateList<WorkoutDay>,
    dayNum: Int,
    switchState: Boolean
) {
    Surface(Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Day ${dayNum + 1}",
                fontSize = Dimens.standardTextSize
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                val workoutDay = list[dayNum]

                Text(text = "Workout Name", fontSize = Dimens.standardTextSize)
                OutlinedTextField(
                    value = workoutDay.title,
                    onValueChange = {
                        list.swapList(viewModel.onModifyWorkoutDay(workoutDay.copy(title = it)))
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { }
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Rest", fontSize = Dimens.standardTextSize)
                    StandardSwitch(
                        state = switchState,
                        onClick = {
                            viewModel.onSwitchRest(it)
                            list.swapList(viewModel.getList())
                        })
                }
                //Exercise Column
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    stickyHeader {
                        Divider(color = Color.Gray, thickness = 1.dp)
                        Text(
                            text = "Exercises",
                            fontSize = Dimens.standardTextSize,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        )
                        Divider(color = Color.Gray, thickness = 1.dp)
                    }
                    item {
                        ExtendedFloatingActionButton(
                            onClick = { /*TODO*/ },
                            icon = {
                                Icon(
                                    painterResource(id = R.drawable.ic_add),
                                    contentDescription = "Menu Icon",
                                )
                            },
                            text = { Text(text = "Exercise", fontSize = 13.sp) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }


            }
        }

    }
}



@ExperimentalMaterialApi
@Composable
fun BackLayer(
    viewModel: CreateScheduleViewModel,
    sliderValue: Float,
    list: SnapshotStateList<WorkoutDay>
) {

    Column(
        Modifier.padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Slider(
                value = sliderValue,
                onValueChange = {
                    viewModel.onChangeSlider(it)
                    list.swapList(viewModel.modifyList(it.toInt()))
                },
                valueRange = 1f..20f,
                steps = 18,
                modifier = Modifier.weight(10f),
                colors = SliderDefaults.colors(
                    thumbColor = sliderColor,
                    activeTickColor = sliderColor,
                    inactiveTickColor = sliderColor
                )
            )
            Text(
                text = sliderValue.toInt().toString(),
                fontSize = Dimens.standardTextSize,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

        LazyColumn {
            items(list) { item ->
                WorkoutDayItem(item = item) {
                    //Implement OnClick Listener
                    viewModel.onChangeDay(item.dayNum)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun WorkoutDayItem(item: WorkoutDay, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
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
                text = if (item.isRest) "Rest" else item.title,
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
        isRest = true
    )
    WorkoutDayItem(item = item) {
    }
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
