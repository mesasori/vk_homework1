package com.example.vk_homework1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        val columns = adapter.getOrientation(view)

        recyclerView = view.findViewById(R.id.rv)
        recyclerView.layoutManager = GridLayoutManager(context, columns)
        recyclerView.adapter = adapter

        addBtn = view.findViewById(R.id.button)
        addBtn.setOnClickListener {
            adapter.count++
            adapter.notifyItemInserted(adapter.count - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(key, adapter.count)
    }

}