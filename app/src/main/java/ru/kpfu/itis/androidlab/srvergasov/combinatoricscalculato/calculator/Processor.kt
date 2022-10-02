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
        }
        return ""
    }
}