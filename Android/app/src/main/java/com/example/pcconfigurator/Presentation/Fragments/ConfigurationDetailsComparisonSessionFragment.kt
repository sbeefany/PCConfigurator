package com.example.pcconfigurator.Presentation.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationDetailsAdapter
import com.example.pcconfigurator.Presentation.Presenters.ConfigurationDetailsPresenter
import com.example.pcconfigurator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ConfigurationDetailsComparisonSessionFragment():Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConfigurationDetailsAdapter
    private lateinit var emptyList: ImageView
    private lateinit var presenter: ConfigurationDetailsPresenter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configuration_details, container, false)
        initViews(view)
        presenter = ConfigurationDetailsPresenter(this)
        presenter.setUpCurrentConfiguration(configuration)

        return view
    }

    private fun initViews(view: View) {

        recyclerView = view.findViewById(R.id.recycler_view_configurations_details)
        emptyList = view.findViewById(R.id.image_empty_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ConfigurationDetailsAdapter(listOf(), )
        recyclerView.adapter = adapter

    }
}