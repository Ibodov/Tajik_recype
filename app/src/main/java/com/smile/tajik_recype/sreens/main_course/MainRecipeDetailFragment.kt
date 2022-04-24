package com.smile.tajik_recype.sreens.main_course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smile.tajik_recype.R
import com.smile.tajik_recype.databinding.FragmentMainRecipeDetailBinding
import com.smile.tajik_recype.models.AppTajikRecype
import com.smile.tajik_recype.models.MainAppTajikRecipe

class MainRecipeDetailFragment : Fragment() {

    private var _binding: FragmentMainRecipeDetailBinding? = null
    private val mBinding get() = _binding!!
//    private lateinit var mCurrentMainRecipe : MainAppTajikRecipe
    private lateinit var mCurrentMainRecipe : AppTajikRecype

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainRecipeDetailBinding.inflate(layoutInflater, container, false)
        mCurrentMainRecipe =
            arguments?.getSerializable("MainRecipe") as AppTajikRecype
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mBinding.mainFoodTitle.text = mCurrentMainRecipe.title
        mBinding.descriptionTV1.text = mCurrentMainRecipe.description
        mBinding.foodImage.setImageResource(mCurrentMainRecipe.image)
        mBinding.ingredients.text = mCurrentMainRecipe.ingredients
        mBinding.steps.text = mCurrentMainRecipe.steps
        mBinding.link.text = mCurrentMainRecipe.link
    }


}