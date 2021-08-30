package com.bios.adapterdelegatestest.models.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bios.adapterdelegatestest.R
import com.bios.adapterdelegatestest.models.models.*

class AdapterDog : AdapterDelegate<Animal> {

    override fun isForViewType(items: List<Animal>, position: Int): Boolean {
        return items.get(position) is Dog
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        items: List<Animal>, position: Int, holder: RecyclerView.ViewHolder
    ) {
        val dog = items.get(position) as Dog
        val vh = holder as ViewHolder
        vh.bindDog(dog)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView
        val tvText: TextView

        init {
            tvTitle = view.findViewById(R.id.tvName)
            tvText = view.findViewById(R.id.tvIntroducing)
        }

        fun bindDog(dog: Dog) {

            tvTitle.text = "Собачка=)"
            tvText.text = dog.inroduceYourSelf()
        }
    }
}