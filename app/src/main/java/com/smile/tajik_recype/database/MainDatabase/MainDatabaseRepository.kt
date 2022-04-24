package com.smile.tajik_recype.database.MainDatabase

import androidx.lifecycle.LiveData
import com.smile.tajik_recype.models.MainAppTajikRecipe

interface MainDatabaseRepository {
    val allMainRecipe : LiveData<List<MainAppTajikRecipe>>


    suspend fun insert(mainRecipe: MainAppTajikRecipe)
    suspend fun delete(mainRecipe: MainAppTajikRecipe, onSuccess: () -> Unit)
}