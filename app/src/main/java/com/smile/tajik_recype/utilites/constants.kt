package com.smile.tajik_recype.utilites

import com.smile.tajik_recype.MainActivity
import com.smile.tajik_recype.database.DatabaseRepository
import com.smile.tajik_recype.database.MainDatabase.MainDatabaseRepository

lateinit var APP_ACTIVITY : MainActivity
lateinit var REPOSITORY : DatabaseRepository

lateinit var MAIN_REPOSITORY : MainDatabaseRepository

const val FIRST_RECYPE = "type_firstRecype"
const val MAIN_RECYPE = "type_mainRecype"