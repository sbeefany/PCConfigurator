package com.example.pcconfigurator.Presentation.Fragments

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.Models.*
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationDetailsAdapter
import com.example.pcconfigurator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ConfigurationDetailsPageFragment(val configuration: com.example.pcconfigurator.Data.Models.Configuration) :
    Fragment() {

    private lateinit var activity: IMainActivity
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ConfigurationDetailsAdapter
    private lateinit var emptyList: ImageView
    private lateinit var floatingActionButton: FloatingActionButton


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val parentActivity = getActivity()
        if (parentActivity is IMainActivity) {
            activity = parentActivity
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configuration_details, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        activity.changeTitle(configuration.title)
        recyclerView = view.findViewById(R.id.recycler_view_configurations_details)
        emptyList = view.findViewById(R.id.image_empty_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ConfigurationDetailsAdapter(configuration.accessories)
        recyclerView.adapter = adapter
        if (configuration.accessories.isEmpty()) {
            emptyList.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            emptyList.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
        floatingActionButton =
            view.findViewById(R.id.configuration_details_accessories_floating_action_button)
        floatingActionButton.setOnClickListener {
            activity.changeFragment(SearchAccessoryFragment())
        }
    }


}