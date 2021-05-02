package com.example.pcconfigurator.Presentation.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf
import androidx.core.view.OneShotPreDrawListener.add
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit


import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Fragments.MyFragmentFactory
import com.example.pcconfigurator.Presentation.Fragments.PcConfiguratorStartPageFragment
import com.example.pcconfigurator.R

class MainActivity : AppCompatActivity(), IMainActivity {


    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MyFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            initFragment()
        }


    }

    private fun initFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<PcConfiguratorStartPageFragment>(R.id.main_activity_container_view)
        }

    }

    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.main_activity_container_view, fragment)
            addToBackStack(null)
        }
    }

    override fun changeTitle(tittle: String) {
        supportActionBar?.let {  it.title = tittle }
    }
}