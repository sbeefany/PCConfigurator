package com.example.pcconfigurator.Presentation.Fragments

import Accessory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.SearchAccessoriesAdapter
import com.example.pcconfigurator.Presentation.Presenters.SearchAccessoriesPresenter
import com.example.pcconfigurator.R

class SearchAccessoryFragment : Fragment(), ISearchAccessories, IClickListenerCallBack {

    private lateinit var activity: IMainActivity
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SearchAccessoriesAdapter
    private val searchAccessoriesPresenter = SearchAccessoriesPresenter(this)

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
        val view: View = inflater.inflate(R.layout.fragment_search_accessories, container, false)
        initViews(view)
        searchAccessoriesPresenter.getLastResult()
        activity.visibilitySpinner(true, searchAccessoriesPresenter)

        return view
    }


    private fun initViews(view: View) {
        recyclerView = view.findViewById(R.id.search_accessories_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = SearchAccessoriesAdapter(listOf(), this, context)
        recyclerView.adapter = adapter
        activity.changeTitle("Поиск")
    }

    override fun showAccessories(accessories: List<Accessory>) {
        adapter.updateList(accessories)
    }

    override fun onStop() {
        super.onStop()
        activity.visibilitySpinner(false, searchAccessoriesPresenter)
    }

    override fun onDestroy() {
        super.onDestroy()
        searchAccessoriesPresenter.view = null
    }

    override fun itemClick(position: Int) {
        getActivity()?.let {
            val fragmentFactory =
                it.supportFragmentManager.fragmentFactory as MyFragmentFactory

            fragmentFactory.accessory = adapter.accessories.get(position)

            val fragment = fragmentFactory.instantiate(
                it.classLoader,
                AccessoryDetailsFragment::class.java.name
            )
            activity.changeFragment(fragment, "AccessoryDetailsFragment")
        }
    }

}