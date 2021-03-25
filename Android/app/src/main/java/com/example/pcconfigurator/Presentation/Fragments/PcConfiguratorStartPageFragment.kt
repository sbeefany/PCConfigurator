package com.example.pcconfigurator.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.IConfigurationsRepository
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationsAdapter
import com.example.pcconfigurator.Presentation.Presenters.ConfigurationsPresenter
import com.example.pcconfigurator.R

class PcConfiguratorStartPageFragment: Fragment(),
    IConfigurationsView {

    private lateinit var activity: IMainActivity
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageView: ImageView
    private lateinit var configurationsAdapter: ConfigurationsAdapter
    private val presenter:ConfigurationsPresenter = ConfigurationsPresenter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.fragment_pc_configurator_start_page, container, false)
        initViews(view)
        presenter.view=this
        presenter.getConfigurations()

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val parentActivity = getActivity()
        if (parentActivity is IMainActivity) {
            activity = parentActivity
        }
    }

    override fun showConfigurations(configurations: List<Configuration>) {
        configurationsAdapter.updateList(configurations)
    }

    override fun showWindowWithoutConfigurations() {
        recyclerView.visibility = View.GONE
        imageView.visibility = View.VISIBLE
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.recycler_view_configurations)
        configurationsAdapter = ConfigurationsAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = configurationsAdapter

    }
}