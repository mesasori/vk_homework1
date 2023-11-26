package com.example.vk_homework1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat

private const val ARG_PARAM1 = "key"


class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt(ARG_PARAM1) ?: 0
        //val position = savedInstanceState?.getInt(ARG_PARAM1) ?: 0
        val textView = view.findViewById<TextView>(R.id.tv_info)
        textView.text = position.toString()
        when (position % 2) {
            0 -> view.background = ContextCompat.getDrawable(view.context, R.drawable.red_card_view)
            1 -> view.background = ContextCompat.getDrawable(view.context, R.drawable.blue_card_view)
        }
    }

}