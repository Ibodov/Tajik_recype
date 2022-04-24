package com.smile.tajik_recype.sreens.first_recype

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smile.tajik_recype.R
import com.smile.tajik_recype.models.AppTajikRecype

class FirstRecipeAdapter() : RecyclerView.Adapter<FirstRecipeAdapter.FirstCourseHolder>() {
    private var mListFirstCourse = emptyList<AppTajikRecype>()

    class FirstCourseHolder(view: View) : RecyclerView.ViewHolder(view) {

        /*val mImage: ImageView = view.findViewById(R.id.food_image)
          val title: TextView = view.findViewById(R.id.food_title)
          val description: TextView = view.findViewById(R.id.descriptionTV)*/
        var mImage: ImageView? = null
        var title: TextView? = null
//        var description: TextView? = null

        init {
            mImage = itemView.findViewById(R.id.food_image)
            title = itemView.findViewById(R.id.food_title)
//            description = itemView.findViewById(R.id.descriptionTV)

        }

        fun initFirsCourse(item: AppTajikRecype) {
            mImage?.setImageResource(item.image)
            title?.text = item.title
//            description?.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstCourseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recype_item, parent, false)
        return FirstCourseHolder(view)
    }

    override fun onBindViewHolder(holder: FirstCourseHolder, position: Int) {
        mListFirstCourse.let {
            holder.initFirsCourse(it[position])
        }

    }

    //нажатие на элемент в RV
    override fun onViewAttachedToWindow(holder: FirstCourseHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            FirstRecipeFragment.click(mListFirstCourse[holder.adapterPosition])
        }
    }

    //отключения слушателя клика holder a (после ухода с экрана)
    override fun onViewDetachedFromWindow(holder: FirstCourseHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }


    override fun getItemCount(): Int {
        return mListFirstCourse.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AppTajikRecype>) {
        mListFirstCourse = list
        notifyDataSetChanged()
    }


}