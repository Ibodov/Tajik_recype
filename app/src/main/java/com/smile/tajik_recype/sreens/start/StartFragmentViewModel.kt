package com.smile.tajik_recype.sreens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.smile.tajik_recype.database.MainDatabase.mainRoom.MainAppRoomDatabase
import com.smile.tajik_recype.database.MainDatabase.mainRoom.MainAppRoomRepository
import com.smile.tajik_recype.database.room.AppRoomDatabase
import com.smile.tajik_recype.database.room.AppRoomRepository
import com.smile.tajik_recype.utilites.REPOSITORY
import com.smile.tajik_recype.utilites.FIRST_RECYPE
import com.smile.tajik_recype.utilites.MAIN_RECYPE
import com.smile.tajik_recype.utilites.MAIN_REPOSITORY

class StartFragmentViewModel(application: Application):AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(type: String, onSuccess:()->Unit) {
        when(type) {
            FIRST_RECYPE -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            MAIN_RECYPE -> {
                val dao = MainAppRoomDatabase.getInstance(mContext).getMainAppRoomDao()
                MAIN_REPOSITORY = MainAppRoomRepository(dao)
                onSuccess()
            }
        }
    }
}