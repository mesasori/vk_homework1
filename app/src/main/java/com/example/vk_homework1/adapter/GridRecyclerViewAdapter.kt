package com.example.vk_homework1.adapter

import android.content.res.Configuration
import android.content.res.Resources
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_homework1.R


class GridRecyclerViewAdapter(): RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder>() {
    var count: Int = 40

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridRecyclerViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        val columns = getOrientation(view)
        val lp = view.layoutParams
        lp.height = parent.measuredWidth / columns - 30.toPx.toInt()
        view.layoutParams = lp
        return MyViewHolder(view)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.tv_position)
        fun onBind(position: Int) {
            textView.text = position.toString()

            when (position % 2) {
                0 -> {
                    //itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.red))
                    itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.red_card_view)
                }

                1 -> itemView.background = ContextCompat.getDrawable(itemView.context, R.drawable.blue_card_view)
            }

        }
    }

    override fun onBindViewHolder(holder: GridRecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return count
    }

    private val Number.toPx
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            Resources.getSystem().displayMetrics)

    fun getOrientation(view: View): Int {
        return when (view.context.resources.configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> 3
            Configuration.ORIENTATION_LANDSCAPE -> 4
            else -> throw UnknownError("Unknown Orientation")
        }
    }


}