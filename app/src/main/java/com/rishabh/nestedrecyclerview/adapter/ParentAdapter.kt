package com.rishabh.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rishabh.nestedrecyclerview.R
import com.rishabh.nestedrecyclerview.adapter.ParentAdapter.ViewHolder
import com.rishabh.nestedrecyclerview.databinding.ParentItemBinding
import com.rishabh.nestedrecyclerview.dtos.ParentDTO

class ParentAdapter(private val data: List<ParentDTO>) : RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(private val itemView: View, val binding: ParentItemBinding) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.parent_item, parent, false) as ParentItemBinding
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.data = data[position]
        holder.binding.rvChildren.adapter = ChildAdapter(data[position].children)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = data.size
}