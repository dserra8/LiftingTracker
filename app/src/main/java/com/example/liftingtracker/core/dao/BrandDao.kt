package com.example.liftingtracker.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.liftingtracker.core.models.Brand
import com.example.liftingtracker.core.models.Exercise

@Dao
interface BrandDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrand(item: Brand) : Long

    @Query(
        "SELECT * FROM brand,exercise " +
                "JOIN crossref ON brand.brandId = crossref.brandId AND exercise.exerciseId = crossref.exerciseId"
    )
    suspend fun loadBrandsWithExercises() : Map<Brand, List<Exercise>>
}