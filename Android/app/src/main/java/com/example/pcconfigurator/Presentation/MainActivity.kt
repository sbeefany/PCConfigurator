package com.example.pcconfigurator.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add

import androidx.fragment.app.commit
import com.example.pcconfigurator.Data.TestRepository
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Fragments.FragmentsFactory
import com.example.pcconfigurator.Presentation.Fragments.PcConfiguratorStartPageFragment
import com.example.pcconfigurator.R

class MainActivity : AppCompatActivity(), IMainActivity {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FragmentsFactory(TestRepository())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null)
            initFragment(314314314)

    }

    override fun changeFragment(fragment: Fragment, data: Int) {
        val bundle: Bundle = bundleOf("some_int" to data)
        fragment.arguments = bundle;
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.main_activity_container_view,fragment)
            addToBackStack(null)
        }
    }

    private fun initFragment(data: Int) {
        val bundle: Bundle = bundleOf("some_int" to data)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<PcConfiguratorStartPageFragment>(R.id.main_activity_container_view,"",bundle)
        }

    }
}