package com.smile.tajik_recype.sreens.first_recype

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.smile.tajik_recype.models.AppTajikRecype
import com.smile.tajik_recype.utilites.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstRecipeViewModel(application: Application) : AndroidViewModel(application) {

    val firstCourses = REPOSITORY.allFirstCourse
    val firstRecipes = REPOSITORY.firstRecipes

    val firstRecype = REPOSITORY
    fun getRecipe() {
//viewModelScope.launch(Dispatchers.Main) {
//REPOSITORY
//}
    }


}