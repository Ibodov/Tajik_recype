package com.smile.tajik_recype.sreens.first_recype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smile.tajik_recype.R
import com.smile.tajik_recype.databinding.FragmentFirstCourseBinding
import com.smile.tajik_recype.models.AppTajikRecype
import com.smile.tajik_recype.utilites.APP_ACTIVITY

//Первое блюдо
class FirstRecipeFragment : Fragment() {

    private var _binding: FragmentFirstCourseBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: FirstRecipeViewModel

//    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mRecyclerView: RecyclerView


    private lateinit var mAdapter: FirstRecipeAdapter
    private lateinit var mObserverList: Observer<List<AppTajikRecype>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstCourseBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//val callback = requireActivity().
//    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(FirstRecipeViewModel::class.java)
        mAdapter = FirstRecipeAdapter()

        mRecyclerView = mBinding.recyclerView
        mRecyclerView.layoutManager = GridLayoutManager(context, 2)
        mRecyclerView.adapter = mAdapter
        mObserverList = Observer {
            val list = it
            mAdapter.setList(list)
        }
//        mViewModel.firstCourses.observe(this, mObserverList)
        mViewModel.firstRecipes.observe(viewLifecycleOwner, mObserverList)
//        mViewModel.getRecipe()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
fun click(FirstRecype:AppTajikRecype) {
    val bundle = Bundle()
    bundle.putSerializable("FirstRecype", FirstRecype)

    APP_ACTIVITY.navController.navigate(R.id.action_firstCourseFragment_to_firstCourseDetailFragment, bundle)
//    APP_ACTIVITY.navController.navigate(R.id.action_firstCourseFragment_to_firstCourseDetailFragment)
}
    }


}