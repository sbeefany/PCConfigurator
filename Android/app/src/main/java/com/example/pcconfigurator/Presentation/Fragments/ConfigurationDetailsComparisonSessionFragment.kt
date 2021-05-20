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
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationDetailsAdapter
import com.example.pcconfigurator.Presentation.Presenters.ConfigurationDetailsPresenter
import com.example.pcconfigurator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ConfigurationDetailsComparisonSessionFragment(val configuration: Configuration?) :
    Fragment(),IClickListenerCallBack {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConfigurationDetailsAdapter
    private lateinit var emptyConfiguration: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configuration_details_comparison_sessions, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        emptyConfiguration = view.findViewById(R.id.empty_configuration)
        recyclerView = view.findViewById(R.id.recycler_view_configurations_details_comparison_session)
        if (configuration != null) {
            emptyConfiguration.visibility=View.GONE
            recyclerView.visibility=View.VISIBLE
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = ConfigurationDetailsAdapter(configuration.accessories,this)
            recyclerView.adapter = adapter
        } else {
            emptyConfiguration.visibility=View.VISIBLE
            recyclerView.visibility=View.GONE
        }

    }

    override fun itemClick(position: Int) {
        TODO("Not yet implemented")
    }
}