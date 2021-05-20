package com.example.pcconfigurator.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.pcconfigurator.Data.Models.Configuration
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.ComparisonSessionFragmentPagerAdapter
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationsAdapter
import com.example.pcconfigurator.Presentation.Dialogs.CreateConfigurationDialogFragment
import com.example.pcconfigurator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import java.lang.IllegalStateException

class ComparisonSessionFragment : Fragment() {

    private lateinit var activity: IMainActivity
    private lateinit var mainFab: FloatingActionButton
    private lateinit var invitePerson: FloatingActionButton
    private lateinit var addConfiguration: FloatingActionButton
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    private var flag = false
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
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_comparison_session, container, false)
        initViews(view)

        return view
    }

    private fun initViews(view: View) {
        mainFab = view.findViewById(R.id.main_fab_comparison_session)
        invitePerson = view.findViewById(R.id.invite_person)
        addConfiguration = view.findViewById(R.id.add_configuration_comparison_session)
        tabLayout = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = ComparisonSessionFragmentPagerAdapter(requireFragmentManager(),
            listOf(getFragment(null),getFragment(null)))
        tabLayout.setupWithViewPager(viewPager)

        activity.changeTitle("Сессия сравнения")

        mainFab.setOnClickListener {
            if (flag) {
                mainFab.setImageDrawable(resources.getDrawable(R.drawable.ic_plus))
                flag = false
                invitePerson.visibility = View.GONE
                addConfiguration.visibility = View.GONE
            } else {
                mainFab.setImageDrawable(resources.getDrawable(R.drawable.ic_cancel))
                flag = true
                invitePerson.visibility = View.VISIBLE
                addConfiguration.visibility = View.VISIBLE
            }
        }


    }

    private fun getFragment(configuration:Configuration?): Fragment {
        getActivity()?.let {
            val fragmentFactory =
                it.supportFragmentManager.fragmentFactory as MyFragmentFactory

            fragmentFactory.comparisonSessionConfiguration = configuration

            return fragmentFactory.instantiate(
                it.classLoader,
                ConfigurationDetailsComparisonSessionFragment::class.java.name
            )
        }
        throw IllegalStateException("Activity was not attached")
    }

    override fun onResume() {
        super.onResume()
        flag = false
    }

}