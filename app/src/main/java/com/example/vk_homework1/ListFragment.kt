package com.example.vk_homework1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_homework1.adapter.GridRecyclerViewAdapter


class ListFragment : Fragment() {
    private val key = "COUNT"

    private lateinit var recyclerView: RecyclerView
    private val adapter = GridRecyclerViewAdapter()
    private lateinit var addBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.count = savedInstanceState?.getInt(key) ?: 0
        val columns = getOrientation(view)

        recyclerView = view.findViewById(R.id.rv)
        recyclerView.layoutManager = GridLayoutManager(context, columns)
        recyclerView.adapter = adapter

        addBtn = view.findViewById(R.id.button)
        addBtn.setOnClickListener {
            adapter.notifyItemInserted(adapter.count)
            adapter.count++
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(key, adapter.count)
    }

    private fun getOrientation(view: View): Int {
        return view.resources.getInteger(R.integer.column_number)
    }

}