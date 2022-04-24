package com.smile.tajik_recype.database.room

import androidx.lifecycle.LiveData
import com.smile.tajik_recype.database.DatabaseRepository
import com.smile.tajik_recype.models.AppTajikRecype

class AppRoomRepository(private val appRoomRepository: AppRoomDao) : DatabaseRepository {
    override val allFirstCourse: LiveData<List<AppTajikRecype>>
        get() = appRoomRepository.getAllRecipes()

    override val firstRecipes: LiveData<List<AppTajikRecype>>
        get() = appRoomRepository.getFirstRecipes()

    override val secondRecipes: LiveData<List<AppTajikRecype>>
        get() = appRoomRepository.getSecondRecipes()

    override suspend fun getTypeRecipe(id: Int): LiveData<List<AppTajikRecype>> {
        return appRoomRepository.getTypeRecipes()
    }

    override suspend fun getTypeRecipeFirst(recipe: AppTajikRecype): LiveData<List<AppTajikRecype>> {
        return appRoomRepository.getTypeRecipeFirst()
    }


    override suspend fun insert(recipe: AppTajikRecype) {
        appRoomRepository.insert(recipe)
    }

    override suspend fun delete(recipe: AppTajikRecype, onSuccess: () -> Unit) {
        appRoomRepository.delete(recipe)
    }
}