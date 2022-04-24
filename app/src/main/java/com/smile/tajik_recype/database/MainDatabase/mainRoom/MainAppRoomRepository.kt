package com.smile.tajik_recype.database.MainDatabase.mainRoom

import androidx.lifecycle.LiveData
import com.smile.tajik_recype.database.MainDatabase.MainDatabaseRepository
import com.smile.tajik_recype.models.MainAppTajikRecipe

class MainAppRoomRepository(private val mainAppRoomRepository: MainAppRoomDao) : MainDatabaseRepository {
    override val allMainRecipe: LiveData<List<MainAppTajikRecipe>>
        get() = mainAppRoomRepository.getMainAllRecipes()

    override suspend fun insert(mainRecipe: MainAppTajikRecipe) {
        mainAppRoomRepository.insert(mainRecipe)
    }

    override suspend fun delete(mainRecipe: MainAppTajikRecipe, onSuccess: () -> Unit) {
        mainAppRoomRepository.delete(mainRecipe)
    }

}