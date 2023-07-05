package com.example.liftingtracker.core.views.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StandardCard(
    modifier: Modifier = Modifier,
    elevation : CardElevation = CardDefaults.elevatedCardElevation(),
    shape: Shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    content : @Composable() (ColumnScope.() -> Unit),
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        elevation = elevation,
        shape = shape,
        content = content,
    )
}

@Preview(showBackground = true)
@Composable
fun StandardCardPreview() {
    StandardCard {
        Box(
            modifier = Modifier.size(100.dp)
        )
    }
}