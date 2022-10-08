package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator

class Validator {
    fun validatePermutations(n: Int) = n in 1..9999
    fun validatePermutationsWithRep(nums: IntArray): Boolean {
        nums.forEach {
            if (it < 1 || it > 10000) {
                return false
            }
        }
        return true
    }
    fun validatePlacements(n: Int, m: Int) = (n in 1..999) && (m in 1..999) && (n >= m)
    fun validatePlacementsWithRep(n: Int, m: Int) = validatePlacements(n, m)
    fun validateCombinations(n: Int, m: Int) = validatePlacements(n, m)
    fun validateCombinationsWithRep(n: Int, m: Int) = validatePlacements(n, m)
}