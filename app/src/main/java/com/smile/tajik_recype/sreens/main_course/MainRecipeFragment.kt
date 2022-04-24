package com.smile.tajik_recype.sreens.main_course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.smile.tajik_recype.R
import com.smile.tajik_recype.databinding.FragmentMainRecypeBinding
import com.smile.tajik_recype.models.AppTajikRecype
import com.smile.tajik_recype.utilites.APP_ACTIVITY

import java.util.*

//Второе блюдо
class MainRecipeFragment : Fragment() {

    private var  _binding: FragmentMainRecypeBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel : MainRecipeViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainRecipeAdapter
//    private lateinit var mAdapter: FirstRecipeAdapter
//    private lateinit var mObserverList: Observer<List<MainAppTajikRecipe>>
    private lateinit var mObserverList: Observer<List<AppTajikRecype>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainRecypeBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(MainRecipeViewModel::class.java)
        mAdapter = MainRecipeAdapter()
        mRecyclerView = mBinding.mainRecyclerView
        mRecyclerView.layoutManager = GridLayoutManager(context, 2)
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it
            mAdapter.setList(list)
        }

        mViewModel.secondRecipes.observe(viewLifecycleOwner, mObserverList)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun mainClick(MainRecipe: AppTajikRecype) {
            val mainBundle = Bundle()
            mainBundle.putSerializable("MainRecipe", MainRecipe)

            APP_ACTIVITY.navController.navigate(R.id.action_mainCourseFragment_to_mainCourseDetailFragment, mainBundle)
        }

    }


}