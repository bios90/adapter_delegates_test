package com.bios.adapterdelegatestest.models.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.RuntimeException

class AdapterDelegatesManager<T> {

    var delegates: MutableList<AdapterDelegate<T>> = arrayListOf()

    fun addDelegate(delegate: AdapterDelegate<T>) = apply({
        delegates.add(delegate)
    })

    fun getItemViewType(items: List<T>, position: Int): Int {
        for ((index, delegate) in delegates.withIndex()) {
            if (delegate.isForViewType(items, position)) {
                return index
            }
        }
        throw RuntimeException("*** Error unknown type ****")
    }

    fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        for ((index, delegate) in delegates.withIndex()) {
            if (index == type) {
                return delegate.onCreateViewHolder(parent)
            }
        }
        throw RuntimeException("*** Error unknown type ****")
    }

    fun onBindViewHolder(items: List<T>, position: Int, viewHolder: RecyclerView.ViewHolder) {
        val viewType = viewHolder.itemViewType
        for ((index, delegate) in delegates.withIndex()) {
            if (index == viewType) {
                delegate.onBindViewHolder(items, position, viewHolder)
            }
        }
    }
}