package com.smile.tajik_recype.sreens.main_course

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smile.tajik_recype.R
import com.smile.tajik_recype.models.AppTajikRecype
import com.smile.tajik_recype.models.MainAppTajikRecipe

class MainRecipeAdapter(): RecyclerView.Adapter<MainRecipeAdapter.MainRecipeHolder>() {

    private var mListMainRecipe = emptyList<AppTajikRecype>()

    class MainRecipeHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mImage: ImageView? = null
        var title: TextView? = null
//        var description: TextView? = null

        init {
            mImage = itemView.findViewById(R.id.food_image)
            title = itemView.findViewById(R.id.food_title)
//            description = itemView.findViewById(R.id.descriptionTV)
        }
        fun initMainRecipe(item: AppTajikRecype) {
            mImage?.setImageResource(item.image)
            title?.text = item.title
//            description?.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRecipeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recype_item, parent, false)
        return MainRecipeHolder(view)
    }

    override fun onBindViewHolder(holder: MainRecipeHolder, position: Int) {
        mListMainRecipe.let {
            holder.initMainRecipe(it[position])
        }
    }

    //нажатие на элемент в RV
    override fun onViewAttachedToWindow(holder: MainRecipeHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            MainRecipeFragment.mainClick(mListMainRecipe[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainRecipeHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount(): Int {
        return mListMainRecipe.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<AppTajikRecype>) {
        mListMainRecipe = list
        notifyDataSetChanged()
    }


}