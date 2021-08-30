package com.bios.adapterdelegatestest.models.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bios.adapterdelegatestest.R
import com.bios.adapterdelegatestest.models.models.Animal
import com.bios.adapterdelegatestest.models.models.Cat

class AdapterCat : AdapterDelegate<Animal> {

    override fun isForViewType(items: List<Animal>, position: Int): Boolean {
        return items.get(position) is Cat
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        items: List<Animal>, position: Int, holder: RecyclerView.ViewHolder
    ) {
        val cat = items.get(position) as Cat
        val vh = holder as ViewHolder
        vh.bindCat(cat)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView
        val tvText: TextView

        init {
            tvTitle = view.findViewById(R.id.tvName)
            tvText = view.findViewById(R.id.tvIntroducing)
        }

        fun bindCat(cat: Cat) {

            tvTitle.text = "Кот"
            tvText.text = cat.inroduceYourSelf()
        }
    }
}