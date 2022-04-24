package com.smile.tajik_recype.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.smile.tajik_recype.models.AppTajikRecype

@Database(entities = [AppTajikRecype::class], version = 2)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun getAppRoomDao(): AppRoomDao

    companion object {

        @Volatile //это база не должна кешироваться
        private var database: AppRoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppRoomDatabase {
            if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "database"
                )
                    .addCallback(object: RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            // ин функсия хангоми сохтани БД кор мекунад
                            // хар вакте ки даромадед БД месозад апп? санчам ? не , намесозад
                            // як маротиба месозад БД
                            // дигар вакт ки даромадед хамонро мекушояд
                            // Шумо хамон функсияро метонед дар хамин чо созед
                            // БД -ро сохт даннихоша пур кунад
                            // дуруст? мумкин ))))
                            // як бор кунед, нашуд ман мебинам, кадом функцияро дар ин созам ?
                            // функсияи базая пур мекардаги



                            /*----------------------------------*/

//                            addFirstCourse()

                            /*--------------------------------*/


                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build()
                return database as AppRoomDatabase
            } else {
                return database as AppRoomDatabase
            }
        }
    }
}