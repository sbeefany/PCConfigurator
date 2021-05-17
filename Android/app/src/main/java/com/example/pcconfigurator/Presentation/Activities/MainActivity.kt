package com.example.pcconfigurator.Presentation.Activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit


import com.example.pcconfigurator.Presentation.Fragments.MyFragmentFactory
import com.example.pcconfigurator.Presentation.Fragments.PcConfiguratorStartPageFragment
import com.example.pcconfigurator.Presentation.Presenters.SearchAccessoriesPresenter
import com.example.pcconfigurator.R

class MainActivity : AppCompatActivity(), IMainActivity {


    private lateinit var spinner: Spinner
    private lateinit var loupe: ImageView

    private var searchPresenter: SearchAccessoriesPresenter? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MyFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {

            initViews()
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
        findViewById<TextView>(R.id.main_title).text = tittle
    }

    override fun visibilitySpinner(boolean: Boolean, serchPresenter: SearchAccessoriesPresenter) {
        if (boolean) {
            this.searchPresenter = serchPresenter
            spinner.visibility = View.VISIBLE
            loupe.visibility=View.VISIBLE
        } else {
            this.searchPresenter = null
            spinner.visibility = View.GONE
            loupe.visibility=View.GONE
        }
    }

    private fun initViews() {
        loupe = findViewById(R.id.loupe)
        spinner = findViewById<Spinner>(R.id.action_bar_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.accessory_types,
            android.R.layout.simple_spinner_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                searchPresenter?.getAccessories(
                    resources.getStringArray(
                        R.array.accessory_types
                    )[position]
                )
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                searchPresenter?.getAccessories("")

            }

        }
    }
}