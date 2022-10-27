package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.spinner

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner

class SpinnerProcessor(
    private val context: Context
) {

    fun processSpinners(
        spinner: Spinner,
        data: List<String>,
    ) {
        setSpinnerData(spinner, data)
    }

    private fun setSpinnerData(spinner: Spinner, data: List<String>) {
        ArrayAdapter(
            context,
            R.layout.simple_spinner_item,
            data,
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

}