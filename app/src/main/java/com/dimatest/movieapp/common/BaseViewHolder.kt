package com.dimatest.movieapp.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dimatest.movieapp.BR

abstract class BaseViewHolder<DB : ViewDataBinding, T>(private val dataBinding: DB) : RecyclerView.ViewHolder(dataBinding.root) {
    open fun bind(item: T) {
        dataBinding.setVariable(BR.item, item)
    }
}