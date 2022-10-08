package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator.Processor
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var processor: Processor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initProcessor()

        with(binding) {
            btn.setOnClickListener {
                et1.setText(processor.process(et1.text.toString(), IntArray(2).plus(et2.text.toString().toInt())))
            }
        }
    }

    private fun initProcessor() {
        processor = Processor(
            getString(R.string.fnc_name_perm),
            getString(R.string.fnc_name_permRep),
            getString(R.string.fnc_name_plac),
            getString(R.string.fnc_name_placRep),
            getString(R.string.fnc_name_comb),
            getString(R.string.fnc_name_combRep),
        )
    }
}
