package com.example.pcconfigurator.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationDetailsAccessoriesAdapter
import com.example.pcconfigurator.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ConfigurationDetailsAccessoriesFragment(val configuration:Configuration): Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var adapter:ConfigurationDetailsAccessoriesAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configuration_details_accessoories,container,false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.configuration_details_accessories_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter= ConfigurationDetailsAccessoriesAdapter(configuration.accessories)
        recyclerView.adapter=adapter
        floatingActionButton = view.findViewById(R.id.configuration_details_accessories_floating_action_button)
    }
}