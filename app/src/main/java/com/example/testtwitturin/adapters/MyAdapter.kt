package com.example.testtwitturin.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtwitturin.R
import com.example.testtwitturin.data.UserItem
import com.example.testtwitturin.databinding.RcViewUiBinding

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    private var list = emptyList<UserItem>()

    inner class MyViewHolder(item: View): RecyclerView.ViewHolder(item){
        val binding = RcViewUiBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rc_view_ui, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("DiscouragedPrivateApi")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = list[position]

        holder.binding.name.text = data.name
        holder.binding.username.text = data.username
        holder.binding.age.text = data.age.toString()
        holder.binding.bio.text = data.bio
    }
    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<UserItem>) {
        list = newList
        notifyDataSetChanged()
    }
}