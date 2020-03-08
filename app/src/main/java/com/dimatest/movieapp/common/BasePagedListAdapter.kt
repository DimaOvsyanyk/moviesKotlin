package com.dimatest.movieapp.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

abstract class BasePagedListAdapter<T, VH : BaseViewHolder<*, T>, DB : ViewDataBinding>
protected constructor(diffCallback: DiffUtil.ItemCallback<T>) : PagedListAdapter<T, VH>(diffCallback) {

    @get:LayoutRes
    abstract val layoutRes: Int
    protected abstract fun getViewHolder(binding: DB): VH
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding: DB = DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutRes, parent, false)
        return getViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}