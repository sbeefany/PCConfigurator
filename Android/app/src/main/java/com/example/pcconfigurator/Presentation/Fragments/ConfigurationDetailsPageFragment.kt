package com.example.pcconfigurator.Presentation.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationDetailsPageAdapter
import com.example.pcconfigurator.R
import com.google.android.material.tabs.TabLayout

class ConfigurationDetailsPageFragment(val configuration: com.example.pcconfigurator.Data.Models.Configuration) : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var myFragmentManager: FragmentManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myFragmentManager = requireActivity().supportFragmentManager
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
        viewPager = view.findViewById(R.id.configuration_details_viewpager)
        viewPager.adapter = ConfigurationDetailsPageAdapter(
            myFragmentManager,
            listOf<Fragment>(
                myFragmentManager.fragmentFactory.instantiate(
                    requireActivity().classLoader,
                    ConfigurationDetailsInfoFragment::class.java.name
                ),
                myFragmentManager.fragmentFactory.instantiate(
                    requireActivity().classLoader,
                    ConfigurationDetailsAccessoriesFragment::class.java.name
                )

            )
        )

        tabLayout = view.findViewById(R.id.configuration_details_tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }


}