package com.example.pcconfigurator.Presentation.Dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.pcconfigurator.Presentation.Presenters.ConfigurationDetailsPresenter
import com.example.pcconfigurator.Presentation.Presenters.ConfigurationsPresenter
import com.example.pcconfigurator.R
import java.lang.IllegalStateException

class CreateConfigurationDialogFragment : DialogFragment() {
    var presenter:ConfigurationsPresenter?=null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            val view: View = inflater.inflate(R.layout.dialog_create_configuration,null)
            val editText = view.findViewById<EditText>(R.id.configuration_title)
            builder.setView(view)
                .setPositiveButton(R.string.create_answer,
                    DialogInterface.OnClickListener { dialog, id ->
                        presenter?.createConfiguration(editText.text.toString())
                        dialog.dismiss()

                    })
                .setNegativeButton(R.string.cansel_answer,
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")

    }

}