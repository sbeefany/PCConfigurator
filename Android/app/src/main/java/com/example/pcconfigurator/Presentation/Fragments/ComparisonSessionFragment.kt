package com.example.pcconfigurator.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.Presentation.Adapters.ConfigurationsAdapter
import com.example.pcconfigurator.Presentation.Dialogs.CreateConfigurationDialogFragment
import com.example.pcconfigurator.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ComparisonSessionFragment : Fragment() {

    private lateinit var activity: IMainActivity
    private lateinit var mainFab:FloatingActionButton
    private lateinit var invitePerson: FloatingActionButton
    private lateinit var addConfiguration: FloatingActionButton

    private var flag=false
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
        val view = inflater.inflate(R.layout.fragment_comparison_session,container,false)

        return view
    }
    private fun initViews(view: View) {
        mainFab = view.findViewById(R.id.main_fab)
        invitePerson = view.findViewById(R.id.invite_person)
        addConfiguration = view.findViewById(R.id.add_configuration_comparison_session)

        activity.changeTitle("Сессия сравнения")

        mainFab.setOnClickListener{
            if(flag){
                mainFab.setImageDrawable(resources.getDrawable(R.drawable.ic_plus))
                flag=false
                invitePerson.visibility=View.GONE
                addConfiguration.visibility=View.GONE
            }else{
                mainFab.setImageDrawable(resources.getDrawable(R.drawable.ic_cancel))
                flag=true
                invitePerson.visibility=View.VISIBLE
                addConfiguration.visibility=View.VISIBLE
            }
        }


    }

    override fun onResume() {
        super.onResume()
        flag = false
    }

}