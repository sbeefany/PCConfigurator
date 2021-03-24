package com.example.pcconfigurator.Presentation.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pcconfigurator.Data.ITestDataRepository
import com.example.pcconfigurator.Presentation.Activities.IMainActivity
import com.example.pcconfigurator.R

class PcConfiguratorStartPageFragment(val testRepository: ITestDataRepository) : Fragment() {

    private lateinit var activity: IMainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.fragment_pc_configurator_start_page, container, false)
        val textView: TextView = view.findViewById(R.id.testTextView)
        val someData: Int = requireArguments().getInt("some_int")
        textView.text = testRepository.getList().toString()
        textView.setOnClickListener{
            activity.changeFragment(TestFragment(), 112)
        }
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val parentActivity = getActivity()
        if (parentActivity is IMainActivity) {
            activity = parentActivity
        }
    }
}