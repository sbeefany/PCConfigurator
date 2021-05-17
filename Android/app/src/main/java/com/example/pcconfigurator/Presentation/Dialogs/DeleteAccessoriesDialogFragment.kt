package com.example.pcconfigurator.Presentation.Dialogs

import Accessory
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.pcconfigurator.Presentation.Presenters.ConfigurationDetailsPresenter
import com.example.pcconfigurator.R
import java.lang.IllegalStateException

class DeleteAccessoriesDialogFragment : DialogFragment() {

    var presenter: ConfigurationDetailsPresenter? = null
    var accessory: Accessory? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.delete_accessory)
                .setPositiveButton(R.string.positive_answer,
                    DialogInterface.OnClickListener { dialog, id ->
                        presenter?.deleteAccessory(accessory!!)
                        presenter = null
                        accessory = null
                        dialog.dismiss()

                    })
                .setNegativeButton(R.string.negative_answer,
                    DialogInterface.OnClickListener { dialog, id ->
                        presenter = null
                        accessory = null
                        dialog.cancel()
                    })
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")

    }

}