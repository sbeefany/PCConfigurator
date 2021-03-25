package com.example.pcconfigurator.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit


import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Fragments.PcConfiguratorStartPageFragment
import com.example.pcconfigurator.R

class MainActivity : AppCompatActivity(), IMainActivity {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()


    }

    private fun initFragment() {

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<PcConfiguratorStartPageFragment>(R.id.main_activity_container_view)
        }

    }

    override fun changeFragment(fragment: Fragment) {
        TODO("Not yet implemented")
    }
}