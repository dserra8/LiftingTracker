package com.example.liftingtracker.core.states

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.example.liftingtracker.core.util.extensions.restoreWithDefault
import com.example.liftingtracker.core.util.extensions.save

/**
 * Reusable state holder that handles input logic & saves state through activity death.
 *
 * @param isValidInput Implement to enforce character filtering or length checks
 * @param beforeValueChanged Implement to edit input before it officially changes
 * @param onAutofilledSuccessfully Implement to react to successful autofill events
 *
 * @see <a href="https://developer.android.com/codelabs/jetpack-compose-advanced-state-side-effects#5">Code lab</a>
 */
class InputState(
    initialValue: TextFieldValue,
    private val isValidInput: (String) -> Boolean,
    private val beforeValueChanged: ((TextFieldValue) -> TextFieldValue)?,
    private val onAutofilledSuccessfully: (String) -> Unit,
) {

    var value by mutableStateOf(initialValue)
        @VisibleForTesting set

    val text get() = value.text

    /**
     * Update [value] if it doesn't contain invalid input
     *
     * @return true if the input was changed
     */
    fun onValueChanged(newValue: TextFieldValue): Boolean {
        isValidInput(newValue.text).also { isValidInput ->
            if (isValidInput) {
                value = beforeValueChanged?.invoke(newValue) ?: newValue
            }
            return isValidInput
        }
    }

    /**
     * Notifies that the user selected an autofill option with the [onAutofilledSuccessfully] callback
     * and updates [value] with the cursor set to the end position for a better UX.
     */
    fun onValueAutofilled(newValue: String) {
        onValueChanged(
            newValue = TextFieldValue(
                text = newValue,
                selection = TextRange(
                    start = newValue.length,
                    end = newValue.length,
                ),
            )
        ).also { isSuccessful ->
            if (isSuccessful) {
                onAutofilledSuccessfully(newValue)
            }
        }
    }

    fun clear() {
        value = TextFieldValue()
    }

    companion object {
        fun Saver(
            isValidInput: (String) -> Boolean,
            onAutofilledSuccessfully: (String) -> Unit,
            beforeValueChanged: ((TextFieldValue) -> TextFieldValue)?
        ) = Saver<InputState, Any>(
            save = { original ->
                save(
                    value = original.value,
                    saver = TextFieldValue.Saver,
                    scope = this
                )
            },
            restore = { saveable ->
                InputState(
                    initialValue = restoreWithDefault(
                        value = saveable,
                        saver = TextFieldValue.Saver,
                        defaultValue = TextFieldValue()
                    ),
                    isValidInput = isValidInput,
                    onAutofilledSuccessfully = onAutofilledSuccessfully,
                    beforeValueChanged = beforeValueChanged,
                )
            }
        )
    }
}

@Composable
fun rememberSaveableInputState(
    initialValue: TextFieldValue = TextFieldValue(),
    isValidInput: (String) -> Boolean = { true },
    onAutofilledSuccessfully: (String) -> Unit = { },
    beforeValueChanged: ((TextFieldValue) -> TextFieldValue)? = null,
): InputState {
    val saver = InputState.Saver(
        isValidInput = isValidInput,
        onAutofilledSuccessfully = onAutofilledSuccessfully,
        beforeValueChanged = beforeValueChanged,
    )
    return rememberSaveable(saver = saver) {
        InputState(
            initialValue = initialValue,
            isValidInput = isValidInput,
            onAutofilledSuccessfully = onAutofilledSuccessfully,
            beforeValueChanged = beforeValueChanged,
        )
    }
}
