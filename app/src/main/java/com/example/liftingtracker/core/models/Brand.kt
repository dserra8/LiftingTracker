package com.example.liftingtracker.core.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Brand(
    @PrimaryKey
    val brandId : String = UUID.randomUUID().toString(),
    val brandName: String,
    val userCreated: Boolean = false,
)