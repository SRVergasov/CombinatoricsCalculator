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
            spinnerFncName.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    setEtVisibility(spinnerFncName.selectedItem.toString())
                }

            }
        }
    }

    private fun setEtVisibility(funcName: String) {
        with(binding) {
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
