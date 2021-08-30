package com.bios.adapterdelegatestest.models.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bios.adapterdelegatestest.R
import com.bios.adapterdelegatestest.models.models.Animal
import com.bios.adapterdelegatestest.models.models.Cat
import com.bios.adapterdelegatestest.models.models.Eagle
import com.bios.adapterdelegatestest.models.models.Humster

class AdapterHumster : AdapterDelegate<Animal> {

    override fun isForViewType(items: List<Animal>, position: Int): Boolean {
        return items.get(position) is Humster
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_humster, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        items: List<Animal>, position: Int, holder: RecyclerView.ViewHolder
    ) {
        val humster = items.get(position) as Humster
        val vh = holder as ViewHolder
        vh.bindHumster(humster)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView
        val tvText: TextView

        init {
            tvTitle = view.findViewById(R.id.tvName)
            tvText = view.findViewById(R.id.tvIntroducing)
        }

        fun bindHumster(humster: Humster) {

            tvTitle.text = "Хомяк"
            tvText.text = humster.inroduceYourSelf()
        }
    }
}