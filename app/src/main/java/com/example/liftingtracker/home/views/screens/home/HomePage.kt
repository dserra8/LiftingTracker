package com.example.liftingtracker.home.views.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.liftingtracker.R
import com.example.liftingtracker.core.views.components.MainAppBar
import com.example.liftingtracker.core.views.components.theme.Bones
import com.example.liftingtracker.home.states.HomeUiState
import com.example.liftingtracker.home.states.WorkoutLogsUiState
import com.example.liftingtracker.home.views.components.WorkoutLogCard
import com.example.liftingtracker.home.views.previewproviders.HomeUiStatePreviewParameter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    state: HomeUiState,
    onClickTopBar: () -> Unit
) {

    Scaffold(
        topBar = {
            MainAppBar(
                isPopEnabled = false,
                title = {
                    Text(
                        text = stringResource(id = R.string.home_screen_title)
                    )
                },
                actions = {
                    IconButton(
                        onClick = onClickTopBar,
                        content = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_add),
                                contentDescription = null
                            )
                        }
                    )
                }
            )
        },
    ) { padding ->

        when (state) {
            HomeUiState.Error -> TODO()
            is HomeUiState.Initial -> {
                when (val logState = state.workoutLogsUiState) {
                    WorkoutLogsUiState.Error -> TODO()
                    WorkoutLogsUiState.Loading -> {
                        Box(modifier = Modifier.size(100.dp))
                    }
                    is WorkoutLogsUiState.Success -> {
                        LazyColumn(
                            modifier = Modifier
                                .padding(padding),
                            contentPadding = PaddingValues(all = Bones.Dimension.Palette.Dimen8)
                        ) {
                            items(logState.items) { item ->
                                WorkoutLogCard(
                                    data = item,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomePagePreview(
    @PreviewParameter(HomeUiStatePreviewParameter::class)
    state: HomeUiState
) {
    HomePage(
        state = state,
        onClickTopBar = {}
    )
}