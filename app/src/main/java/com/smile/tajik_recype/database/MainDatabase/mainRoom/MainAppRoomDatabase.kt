package com.smile.tajik_recype.database.MainDatabase.mainRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.smile.tajik_recype.models.MainAppTajikRecipe

@Database(entities = [MainAppTajikRecipe::class], version = 1)
abstract class MainAppRoomDatabase : RoomDatabase() {
    abstract fun getMainAppRoomDao() : MainAppRoomDao

    companion object{

        @Volatile //это база не должна кешироваться
        private var mainDatabase: MainAppRoomDatabase? = null

        @Synchronized
        fun getInstance (context: Context) : MainAppRoomDatabase {
            if (mainDatabase == null) {
                mainDatabase = Room.databaseBuilder(
                    context,
                    MainAppRoomDatabase::class.java,
                    "mainDatabase"
                ).build()
                return  mainDatabase as MainAppRoomDatabase
            }else return mainDatabase as MainAppRoomDatabase
        }
    }
}