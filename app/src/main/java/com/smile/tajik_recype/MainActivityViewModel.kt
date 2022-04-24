package com.smile.tajik_recype

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.smile.tajik_recype.database.MainDatabase.mainRoom.MainAppRoomDatabase
import com.smile.tajik_recype.database.MainDatabase.mainRoom.MainAppRoomRepository
import com.smile.tajik_recype.database.room.AppRoomDatabase
import com.smile.tajik_recype.database.room.AppRoomRepository
import com.smile.tajik_recype.models.AppTajikRecype
import com.smile.tajik_recype.models.MainAppTajikRecipe
import com.smile.tajik_recype.utilites.REPOSITORY
import com.smile.tajik_recype.utilites.FIRST_RECYPE
import com.smile.tajik_recype.utilites.MAIN_RECYPE
import com.smile.tajik_recype.utilites.MAIN_REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val mContext = application

    fun initData(type: String) {
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
        val mainDao = MainAppRoomDatabase.getInstance(mContext).getMainAppRoomDao()
        when (type) {
            FIRST_RECYPE -> {
                REPOSITORY = AppRoomRepository(dao)
            }
            MAIN_RECYPE -> {
                MAIN_REPOSITORY = MainAppRoomRepository(mainDao)
            }
        }
    }


    fun insertFirstRecypeToDatabase(
        firstRecypeList: List<AppTajikRecype>
    ) {
        viewModelScope.launch(Dispatchers.Main) {
            firstRecypeList.forEach { REPOSITORY.insert(it) }
        }
    }

    fun insertMainRecypeToDatabase(
        mainRecypeList: List<MainAppTajikRecipe>
    ) {
        viewModelScope.launch(Dispatchers.Main) {
            mainRecypeList.forEach { MAIN_REPOSITORY.insert(it) }
        }
    }
}