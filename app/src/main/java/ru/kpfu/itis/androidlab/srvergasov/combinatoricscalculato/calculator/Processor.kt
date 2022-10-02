package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculato.calculator

class Processor {
    private val validator = Validator()
    private val calculator = Calculator()

    fun process(funcName: String, values: IntArray): String {
        when (funcName) {
            "Permutations" -> {
                if (validator.validatePermutations(values[0])) {
                    return calculator.permutations(values[0]).toString()
                }
            }
            "PermutationsWithRep" -> {
                if (validator.validatePermutationsWithRep(values)) {
                    return calculator.permutationsWithRep(values).toString()
                }
            }
            "Placements" -> {
                if (validator.validatePlacements(values[0], values[1])) {
                    return calculator.placements(values[0], values[1]).toString()
                }
            }
            "PlacementsWithRep" -> {
                if (validator.validatePlacementsWithRep(values[0], values[1])) {
                    return calculator.placementsWithRep(values[0], values[1]).toString()
                }
            }
            "Combinations" -> {
                if (validator.validateCombinations(values[0], values[1])) {
                    return calculator.combinations(values[0], values[1]).toString()
                }
            }
            "CombinationsWithRep" -> {
                if (validator.validateCombinationsWithRep(values[0], values[1])) {
                    return calculator.combinationsWithRep(values[0], values[1]).toString()
                }
            }
        }
        return "Something wrong"
    }
}