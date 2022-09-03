package com.example.liftingtracker.core.views

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.liftingtracker.R


@Composable
fun StandardButton(onClick: ()-> Unit) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(corner = CornerSize(45.dp))
        ) {
            Text(
                text = stringResource(R.string.get_started),
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
    }
}

@Preview
@Composable
fun PreviewButton() {
    StandardButton {

    }
}
