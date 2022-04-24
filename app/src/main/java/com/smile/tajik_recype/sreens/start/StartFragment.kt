package com.smile.tajik_recype.sreens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.smile.tajik_recype.R
import com.smile.tajik_recype.databinding.FragmentStartBinding
import com.smile.tajik_recype.utilites.APP_ACTIVITY
import com.smile.tajik_recype.utilites.FIRST_RECYPE
import com.smile.tajik_recype.utilites.MAIN_RECYPE

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: StartFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {

        mViewModel = ViewModelProvider(this).get(StartFragmentViewModel::class.java)

        mBinding.btnFirstCourse.setOnClickListener {
            mViewModel.initDatabase(FIRST_RECYPE) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_firstCourseFragment)
            }
        }
        mBinding.btnSecondCourse.setOnClickListener {
            mViewModel.initDatabase(MAIN_RECYPE) {
                APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_mainCourseFragment)
            }
        }

    }


}