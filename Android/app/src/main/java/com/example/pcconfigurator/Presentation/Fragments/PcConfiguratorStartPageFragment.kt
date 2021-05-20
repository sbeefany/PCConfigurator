package com.example.pcconfigurator.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Data.IConfigurationsRepository
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationsAdapter
import com.example.pcconfigurator.Presentation.Dialogs.CreateConfigurationDialogFragment
import com.example.pcconfigurator.Presentation.Presenters.ConfigurationsPresenter
import com.example.pcconfigurator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PcConfiguratorStartPageFragment : Fragment(),
    IConfigurationsView, IClickListenerCallBack {

    private lateinit var activity: IMainActivity
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageView: ImageView
    private lateinit var configurationsAdapter: ConfigurationsAdapter
    private lateinit var presenter:ConfigurationsPresenter

    private lateinit var mainFab:FloatingActionButton
    private lateinit var createConfigurationFab:FloatingActionButton
    private lateinit var comparisonSessionFab:FloatingActionButton
    private var flag:Boolean=false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.fragment_pc_configurator_start_page, container, false)
        initViews(view)
        presenter= ConfigurationsPresenter(this)
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
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        recyclerView.visibility = View.GONE
        imageView.visibility = View.GONE
    }

    private fun initViews(view: View) {
        mainFab = view.findViewById(R.id.main_fab)
        createConfigurationFab = view.findViewById(R.id.create_configuration_fab)
        comparisonSessionFab = view.findViewById(R.id.comparison_session_fab)
        recyclerView = view.findViewById(R.id.recycler_view_configurations)
        configurationsAdapter = ConfigurationsAdapter(emptyList(), this)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = configurationsAdapter
        activity.changeTitle("Мои конфигурации")

        mainFab.setOnClickListener{
            if(flag){
                mainFab.setImageDrawable(resources.getDrawable(R.drawable.ic_plus))
                flag=false
                createConfigurationFab.visibility=View.GONE
                comparisonSessionFab.visibility=View.GONE
            }else{
                mainFab.setImageDrawable(resources.getDrawable(R.drawable.ic_cancel))
                flag=true
                createConfigurationFab.visibility=View.VISIBLE
                comparisonSessionFab.visibility=View.VISIBLE
            }
        }

        createConfigurationFab.setOnClickListener {
            val createConfigurationDialog = CreateConfigurationDialogFragment()
            createConfigurationDialog.presenter = presenter
            createConfigurationDialog.show(requireFragmentManager(),"createConfigurationDialog")
        }
        comparisonSessionFab.setOnClickListener {
            activity.changeFragment(ComparisonSessionFragment(),"ComparisonSessionFragment")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.view = null
    }

    override fun itemClick(position: Int) {
        val adapter = recyclerView.adapter as ConfigurationsAdapter

        getActivity()?.let {
            val fragmentFactory =
                it.supportFragmentManager.fragmentFactory as MyFragmentFactory

            fragmentFactory.configuration = adapter.configurations.get(position)

            val fragment = fragmentFactory.instantiate(
                it.classLoader,
                ConfigurationDetailsPageFragment::class.java.name
            )
            activity.changeFragment(fragment,"ConfigurationDetailsFragment")
        }

    }

    override fun onResume() {
        super.onResume()
        flag=false
    }
}