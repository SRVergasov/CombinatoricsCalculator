package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator

import android.content.Context
import ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.R

class CalculatorProcessor(
    private val context: Context,
) {
    private val validator = Validator()
    private val calculator = Calculator()

    private var permutations = ""
    private var permutationsRep = ""
    private var placements = ""
    private var placementsRep = ""
    private var combinations = ""
    private var combinationsRep = ""

    init {
        permutations = context.getString(R.string.fnc_name_perm)
        permutationsRep = context.getString(R.string.fnc_name_permRep)
        placements = context.getString(R.string.fnc_name_plac)
        placementsRep = context.getString(R.string.fnc_name_placRep)
        combinations = context.getString(R.string.fnc_name_comb)
        combinationsRep = context.getString(R.string.fnc_name_combRep)
    }

    fun process(funcName: String, values: IntArray): String {
        when (funcName) {
            permutations -> {
                if (validator.validatePermutations(values[0])) {
                    return calculator.permutations(values[0]).toString()
                }
            }
            permutationsRep -> {
                if (validator.validatePermutationsWithRep(values)) {
                    return calculator.permutationsWithRep(values).toString()
                }
            }
            placements -> {
                if (validator.validatePlacements(values[0], values[1])) {
                    return calculator.placements(values[0], values[1]).toString()
                }
            }
            placementsRep -> {
                if (validator.validatePlacementsWithRep(values[0], values[1])) {
                    return calculator.placementsWithRep(values[0], values[1]).toString()
                }
            }
            combinations -> {
                if (validator.validateCombinations(values[0], values[1])) {
                    return calculator.combinations(values[0], values[1]).toString()
                }
            }
            combinationsRep -> {
                if (validator.validateCombinationsWithRep(values[0], values[1])) {
                    return calculator.combinationsWithRep(values[0], values[1]).toString()
                }
            }
        }
        return validator.getMessage()
    }
}
