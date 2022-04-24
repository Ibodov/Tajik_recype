package com.smile.tajik_recype.database

import androidx.lifecycle.LiveData
import com.smile.tajik_recype.models.AppTajikRecype

interface DatabaseRepository {

    val allFirstCourse: LiveData<List<AppTajikRecype>>
    val firstRecipes: LiveData<List<AppTajikRecype>>
    val secondRecipes: LiveData<List<AppTajikRecype>>
//    suspend fun insert(recipe: AppTajikRecype, onSuccess:()->Unit)
    suspend fun insert(recipe: AppTajikRecype)
    suspend fun delete(recipe: AppTajikRecype, onSuccess: () -> Unit)

    suspend fun getTypeRecipe(id: Int): LiveData<List<AppTajikRecype>>
    suspend fun getTypeRecipeFirst(recipe: AppTajikRecype): LiveData<List<AppTajikRecype>>
}