package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator.CalculatorProcessor
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.databinding.ActivityMainBinding
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.spinner.SpinnerProcessor

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorProcessor: CalculatorProcessor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calculatorProcessor = CalculatorProcessor(this)
        initSpinner()

        with(binding) {
            spinnerFncName.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long,
                ) {
                    setEtVisibility(spinnerFncName.selectedItem.toString())
                }

            }
            btn.setOnClickListener {
                tvAnswer.text = calculatorProcessor.process(
                    spinnerFncName.selectedItem.toString(),
                    getDataList().toIntArray()
                )
            }
        }
    }

    private fun getDataList(): MutableList<Int> {
        with(binding) {
            // TODO: converter!!!!!
            val data = mutableListOf<Int>()
            et1.text?.let {
                if (it.toString().isNotEmpty()) {
                    data.add(it.toString().toInt())
                }
            }
            et2.text?.let {
                if (it.toString().isNotEmpty()) {
                    data.add(it.toString().toInt())
                }
            }
            et3.text?.let {
                if (it.toString().isNotEmpty()) {
                    data.addAll(it.toString().split(",").map { el -> el.toInt() })
                }
            }
            return data
        }
    }

    private fun setEtVisibility(funcName: String) {
        with(binding) {
            et1.setText("")
            et2.setText("")
            et3.setText("")
            tvAnswer.text = ""
            when (funcName) {
                getString(R.string.fnc_name_permRep) -> {
                    et1.visibility = View.GONE
                    et2.visibility = View.GONE
                    et3.visibility = View.VISIBLE
                }
                getString(R.string.fnc_name_perm) -> {
                    et1.visibility = View.VISIBLE
                    et2.visibility = View.GONE
                    et3.visibility = View.GONE
                }
                else -> {
                    et1.visibility = View.VISIBLE
                    et2.visibility = View.VISIBLE
                    et3.visibility = View.GONE
                }
            }
        }
    }

    private fun initSpinner() {
        SpinnerProcessor(this).processSpinners(
            binding.spinnerFncName,
            listOf(
                getString(R.string.fnc_name_perm),
                getString(R.string.fnc_name_permRep),
                getString(R.string.fnc_name_plac),
                getString(R.string.fnc_name_placRep),
                getString(R.string.fnc_name_comb),
                getString(R.string.fnc_name_combRep),
            )
        )
    }
}
