package com.example.liftingtracker.core.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.liftingtracker.core.views.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResizeableTextField(
    value: String,
    labelValue: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    cursorBrush: Brush = SolidColor(Color.Black),
    placeholder: @Composable (() -> Unit)? = null,
    decorationBoxContentPadding: PaddingValues = PaddingValues(all = 8.dp)
) {
    Box {
        BasicTextField(
            modifier = modifier
                .width(IntrinsicSize.Min)
                .widthIn(min = 50.dp),
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            singleLine = singleLine,
            interactionSource = interactionSource,
            decorationBox = {
                TextFieldDefaults.OutlinedTextFieldDecorationBox(
                    value = value,
                    visualTransformation = visualTransformation,
                    innerTextField = it,
                    singleLine = singleLine,
                    enabled = enabled,
                    interactionSource = interactionSource,
                    contentPadding = decorationBoxContentPadding,
                    colors = TextFieldDefaults.outlinedTextFieldColors(),
                    placeholder = placeholder
                )
            },
            textStyle = textStyle,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            readOnly = readOnly,
            maxLines = maxLines,
            cursorBrush = cursorBrush,
            onTextLayout = onTextLayout
        )
        Text(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-8).dp)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            text = labelValue,
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ResizeableTextFieldPreview() {
    AppTheme {
        ResizeableTextField(
            value = "8",
            labelValue = "Reps",
            onValueChange = {}
        )
    }
}