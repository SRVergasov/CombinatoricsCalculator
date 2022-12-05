package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator.CalculatorProcessor
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.databinding.ActivityMainBinding
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.input.InputValidator
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.spinner.SpinnerProcessor

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var calculatorProcessor: CalculatorProcessor
    private lateinit var inputValidator: InputValidator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calculatorProcessor = CalculatorProcessor(this)
        inputValidator = InputValidator()
        initSpinner()
        setListeners()
    }

    private fun setListeners() {
        with(binding) {
            spinnerFncName.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    // nothing
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
                val selectedFun = spinnerFncName.selectedItem.toString()
                val et1Text = et1.text.toString()
                val et2Text = et2.text.toString()
                val et3Text = et3.text.toString()
                if (selectedFun == getString(R.string.fnc_name_permRep)
                    && !inputValidator.validatePermRep(et3Text)
                ) {
                    tvAnswer.text = inputValidator.getMessage()
                } else if (selectedFun == getString(R.string.fnc_name_perm)
                    && !inputValidator.validatePerm(et1Text)
                ) {
                    tvAnswer.text = inputValidator.getMessage()
                } else if (!inputValidator.validateFun2(et1Text, et2Text) &&
                    selectedFun != getString(R.string.fnc_name_perm) &&
                    selectedFun != getString(R.string.fnc_name_permRep)
                ) {
                    tvAnswer.text = inputValidator.getMessage()
                } else {
                    tvAnswer.text = calculatorProcessor.process(
                        spinnerFncName.selectedItem.toString(),
                        getDataList().toIntArray()
                    )
                }
            }
        }
    }

    private fun getDataList(): MutableList<Int> {
        with(binding) {
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
