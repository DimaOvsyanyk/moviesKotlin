package com.dimatest.movieapp.common;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<DB extends ViewDataBinding, T> extends RecyclerView.ViewHolder {

    public DB dataBinding;

    public BaseViewHolder(@NonNull DB dataBinding) {
        super(dataBinding.getRoot());
        this.dataBinding = dataBinding;
    }

    public void bind(T item) {
        dataBinding.setVariable(BR.item, item);
    }
}
