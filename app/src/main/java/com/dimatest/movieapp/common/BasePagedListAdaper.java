package com.dimatest.movieapp.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

public abstract class BasePagedListAdaper<T, VH extends BaseViewHolder, DB extends ViewDataBinding> extends PagedListAdapter<T, VH> {

    @LayoutRes
    public abstract int getLayoutRes();

    protected BasePagedListAdaper(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    protected abstract VH getViewHolder(DB binding);

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DB binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutRes(), parent, false);
        return getViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bind(getItem(position));
    }
}
