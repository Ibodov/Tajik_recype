package com.smile.tajik_recype.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.smile.tajik_recype.models.AppTajikRecype

@Dao
interface AppRoomDao {
    @Query("SELECT * FROM first_recipe")
    fun  getAllRecipes():LiveData<List<AppTajikRecype>>

    @Query("SELECT * FROM first_recipe WHERE type = 2")
    fun getTypeRecipes(): LiveData<List<AppTajikRecype>>

    @Query("SELECT * FROM first_recipe WHERE type = 1")
    fun getFirstRecipes(): LiveData<List<AppTajikRecype>>

    @Query("SELECT * FROM first_recipe WHERE type = 2")
    fun getSecondRecipes(): LiveData<List<AppTajikRecype>>

    @Query("SELECT * FROM first_recipe WHERE type = 1")
    fun getTypeRecipeFirst(): LiveData<List<AppTajikRecype>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recype: AppTajikRecype)

    @Delete
    suspend fun delete(recype: AppTajikRecype)
}