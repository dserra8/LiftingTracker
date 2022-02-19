package com.example.baseproject.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [], version = 1)
abstract class GeneralDatabase: RoomDatabase() {

    //Declare Daos
     abstract fun coreDao(): CoreDao
}