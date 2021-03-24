package com.example.pcconfigurator.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pcconfigurator.R

class TestFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pc_configurator_start_page,container,false)
        val someData = requireArguments().getInt("some_int")
        val textView = view.findViewById<TextView>(R.id.testTextView)
        textView.text = someData.toString()
        textView.setOnClickListener {
            parentFragmentManager.fragments
        }
        return view
    }
}