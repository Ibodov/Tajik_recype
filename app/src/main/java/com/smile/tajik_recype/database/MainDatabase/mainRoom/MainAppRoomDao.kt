package com.smile.tajik_recype.database.MainDatabase.mainRoom

import androidx.lifecycle.LiveData
import androidx.room.*
import com.smile.tajik_recype.models.MainAppTajikRecipe

@Dao
interface MainAppRoomDao {
    @Query("SELECT * FROM main_recype")
    fun getMainAllRecipes():LiveData<List<MainAppTajikRecipe>>

//    @Query("SELECT TYPE = 2 FROM main_recype")

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mainRecype: MainAppTajikRecipe)

    @Delete
    suspend fun delete(mainRecype: MainAppTajikRecipe)
}