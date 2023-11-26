package com.example.vk_homework1.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_homework1.R


class GridRecyclerViewAdapter(): RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder>() {

    var count: Int = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridRecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.tv_position)
        fun onBind(position: Int) {
            textView.text = position.toString()
            when (position % 2) {
                0 -> itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.red_card_view)
                1 -> itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.blue_card_view)
            }

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("key", position)
                Navigation.findNavController(itemView).navigate(R.id.fromList_to_Info, bundle)
            }
        }
    }

    override fun onBindViewHolder(holder: GridRecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = count
}