package com.example.liftingtracker.core.util

import androidx.compose.runtime.snapshots.SnapshotStateList


val <T> T.exhaustive: T
    get() = this

fun <T> SnapshotStateList<T>.swapList(newList: List<T>): SnapshotStateList<T> {
    clear()
    addAll(newList)
    return this
}