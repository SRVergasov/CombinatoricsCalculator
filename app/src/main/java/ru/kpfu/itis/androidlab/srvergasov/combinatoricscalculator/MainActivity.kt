package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
