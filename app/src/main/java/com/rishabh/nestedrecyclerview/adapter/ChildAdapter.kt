package com.rishabh.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rishabh.nestedrecyclerview.R
import com.rishabh.nestedrecyclerview.adapter.ChildAdapter.ViewHolder
import com.rishabh.nestedrecyclerview.databinding.ChildItemBinding
import com.rishabh.nestedrecyclerview.dtos.ChildDTO

class ChildAdapter(private val childData: List<ChildDTO>?) : RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(private val itemView: View, val binding: ChildItemBinding) :
        RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.child_item, parent, false) as ChildItemBinding
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if ((childData?.size ?: 0) > position)
            holder.binding.data = childData?.get(position)

        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = childData?.size ?: 0
}