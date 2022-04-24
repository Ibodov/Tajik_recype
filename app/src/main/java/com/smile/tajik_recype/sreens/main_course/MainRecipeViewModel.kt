package com.smile.tajik_recype.sreens.main_course

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.smile.tajik_recype.utilites.MAIN_REPOSITORY
import com.smile.tajik_recype.utilites.REPOSITORY

class MainRecipeViewModel(application: Application) : AndroidViewModel(application) {
//    val mainRecipe = MAIN_REPOSITORY.allMainRecipe

    val secondRecipes = REPOSITORY.secondRecipes


}