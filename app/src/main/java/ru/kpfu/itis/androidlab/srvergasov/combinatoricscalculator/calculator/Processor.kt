package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator

import android.util.Log

class Processor(
    private val permutations: String = "Permutations",
    private val permutationsRep: String = "PermutationsWithRep",
    private val placements: String = "Placements",
    private val placementsRep: String = "PlacementsWithRep",
    private val combinations: String = "Combinations",
    private val combinationsRep: String = "CombinationsWithRep",
) {
    private val validator = Validator()
    private val calculator = Calculator()

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
        return "Wrong data inputted"
    }
}