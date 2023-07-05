package com.example.liftingtracker.core.views.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.liftingtracker.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    isPopEnabled: Boolean,
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {},
    onBackPressed: () -> Unit = {},
) {
    Column {
        TopAppBar(
            modifier = modifier,
            title = title,
            actions = actions,
            navigationIcon = {
                if (isPopEnabled) {
                    NavigationIcon(
                        onBackPressed = onBackPressed
                    )
                }
            },
        )
    }
}

@Composable
private fun NavigationIcon(
    onBackPressed: () -> Unit,
) {
    IconButton(
        onClick = onBackPressed,
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun MainAppBarPreview() {
    MainAppBar(
        isPopEnabled = true,
        title = {
            Text(text = "Home")
        },
        actions = {
            IconButton(
                onClick = { /*TODO*/ },
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = null
                    )
                }
            )
        }
    )
}