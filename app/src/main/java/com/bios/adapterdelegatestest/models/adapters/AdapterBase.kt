package com.bios.adapterdelegatestest.models.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bios.adapterdelegatestest.models.models.Animal

class AdapterBase : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Animal> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var delegatesManager = AdapterDelegatesManager<Animal>()

    init {
        delegatesManager.addDelegate(AdapterCat())
        delegatesManager.addDelegate(AdapterEagle())
        delegatesManager.addDelegate(AdapterHumster())
        delegatesManager.addDelegate(AdapterDog())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(items, position, holder)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items,position)
    }
}