package com.mishraji.dm_android_assignment.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mishraji.dm_android_assignment.R
import com.mishraji.dm_android_assignment.callback.IOnRecyclerItemClickListener
import com.mishraji.dm_android_assignment.data.Cake
import com.mishraji.dm_android_assignment.databinding.ListItemBinding

class CakeAdapter(val callback: IOnRecyclerItemClickListener) :
    RecyclerView.Adapter<CakeAdapter.CakeViewHolder>() {

    var mList = ArrayList<Cake>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        val binding =
            DataBindingUtil.inflate<ListItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.list_item,
                parent,
                false
            )
        return CakeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        val currentItem = mList[position]
        holder.binding.apply {
            textViewNo.text = currentItem.id
            textViewName.text = currentItem.name
            textViewCount.text = "Toppings count: ${currentItem.topping.size.toString()}"
            root.setOnClickListener { callback.onItemClick(currentItem) }
        }

    }

    class CakeViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cake: Cake) {

        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(mList: ArrayList<Cake>) {
        this.mList = mList
        notifyDataSetChanged()
    }
}