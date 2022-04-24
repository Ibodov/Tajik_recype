package com.smile.tajik_recype.sreens.first_recype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smile.tajik_recype.R
import com.smile.tajik_recype.databinding.FragmentFirstCourseDetailBinding
import com.smile.tajik_recype.models.AppTajikRecype


class FirstRecypeDetailFragment : Fragment() {

    private var _binding: FragmentFirstCourseDetailBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: FirstRecypeDetailFragmentViewModel
    private lateinit var mCurrentFirstRecype: AppTajikRecype

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstCourseDetailBinding.inflate(layoutInflater, container, false)
        mCurrentFirstRecype =
            arguments?.getSerializable("FirstRecype") as AppTajikRecype // получение данных из bundle
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mBinding.foodTitle1.text = mCurrentFirstRecype.title
        mBinding.descriptionTV1.text = mCurrentFirstRecype.description
        mBinding.foodImage.setImageResource(mCurrentFirstRecype.image)
        mBinding.ingredients.text = mCurrentFirstRecype.ingredients
        mBinding.steps.text = mCurrentFirstRecype.steps
        mBinding.link.text = mCurrentFirstRecype.link
    }

}