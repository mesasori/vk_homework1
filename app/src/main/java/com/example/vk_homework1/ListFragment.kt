package com.example.vk_homework1

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_homework1.adapter.GridRecyclerViewAdapter


class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = GridRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val columns = adapter.getOrientation(view)

        recyclerView = view.findViewById(R.id.rv)
        adapter.count = 50
        recyclerView.layoutManager = GridLayoutManager(context, columns)
        recyclerView.adapter = adapter
    }


}