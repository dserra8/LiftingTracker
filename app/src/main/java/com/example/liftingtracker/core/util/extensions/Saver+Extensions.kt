package com.example.liftingtracker.core.util.extensions

import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope

/**
 * Utility function to be able to save nullable values. It also enables not to use with() scope for
 * readability/syntactic purposes.
 *
 * @see [androidx.compose.ui.text.Saver]
 */
fun <T : Saver<Original, Saveable>, Original, Saveable> save(
    value: Original?,
    saver: T,
    scope: SaverScope
): Any {
    return value?.let { with(saver) { scope.save(value) } } ?: false
}

/**
 * Utility function to restore nullable values. It also enables not to use with() scope
 * for readability/syntactic purposes.
 *
 * @see [androidx.compose.ui.text.Saver]
 */
inline fun <T : Saver<Original, Saveable>, Original, Saveable, reified Result> restore(
    value: Saveable?,
    saver: T
): Result? {
    if (value == false) return null
    return value?.let { with(saver) { restore(value) } as Result }
}

/**
 * [restore] wrapper that returns [defaultValue] if the result is null
 */
inline fun <T : Saver<Original, Saveable>, Original, Saveable, reified Result> restoreWithDefault(
    value: Saveable?,
    saver: T,
    defaultValue: Result,
): Result {
    return restore(value, saver) ?: defaultValue
}