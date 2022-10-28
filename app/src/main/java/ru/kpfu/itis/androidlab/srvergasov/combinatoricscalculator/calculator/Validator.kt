package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator

class Validator {
    private var message = ""

    fun validatePermutations(n: Int): Boolean {
        if (n in 1..9999) {
            return true
        }
        message = "число n за пределами допустимых значений (1 - 9999)"
        return false
    }
    fun validatePermutationsWithRep(nums: IntArray): Boolean {
        nums.forEach {
            if (it < 1 || it > 10000) {
                message = "числа за пределами допустимых значений (1 - 9999)"
                return false
            }
        }
        if (nums[0] != nums.slice(1..nums.size).sum()) {
            message = "число n должно быть равно сумме всех последующих"
            return false
        }
        return true
    }

    fun validatePlacements(n: Int, m: Int): Boolean {
        if (n < 1 || n > 999) {
            message = "число n за пределами допустимых значений (1 - 999)"
            return false
        }
        if (m < 1 || m > 999) {
            message = "число m за пределами допустимых значений (1 - 999)"
            return false
        }
        if (n < m) {
            message = "число n должно быть больше числа m"
            return false
        }
        return true
    }

    fun validatePlacementsWithRep(n: Int, m: Int) = validatePlacements(n, m)
    fun validateCombinations(n: Int, m: Int) = validatePlacements(n, m)
    fun validateCombinationsWithRep(n: Int, m: Int) = validatePlacements(n, m)

    fun getMessage() = message
}
