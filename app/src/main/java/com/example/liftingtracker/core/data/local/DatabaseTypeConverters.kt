package com.example.liftingtracker.core.data.local

import androidx.room.TypeConverter
import org.joda.time.DateTime

object DatabaseTypeConverters {

    @JvmStatic
    @TypeConverter
    fun dateTimeFromTimestamp(value: Long?): DateTime? = value?.let { DateTime(it) }

    @JvmStatic
    @TypeConverter
    fun dateTimeToTimestamp(date: DateTime?): Long? = date?.millis
}