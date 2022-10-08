package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.calculator

import java.math.BigInteger

class Calculator {

    fun permutations(num: Int): Number {
        return factTree(num.toBigInteger())
    }

    fun permutationsWithRep(nums: IntArray): Number {
        return factTree(nums.sum().toBigInteger()) / nums.let { array ->
            var sum: BigInteger = BigInteger.ONE
            array.forEach {
                sum *= factTree(it.toBigInteger())
            }
            sum
        }
    }

    fun placements(numN: Int, numM: Int): Number {
        return factTree(numN.toBigInteger()) / factTree((numN - numM).toBigInteger())
    }

    fun placementsWithRep(numN: Int, numM: Int): Number {
        var s = 1
        for (i in 1..numM) {
            s *= numN
        }
        return s
    }

    fun combinations(numN: Int, numM: Int): Number {
        return factTree(numN.toBigInteger()) /
                (factTree(numM.toBigInteger()) * factTree((numN - numM).toBigInteger()))
    }

    fun combinationsWithRep(numN: Int, numM: Int): Number {
        return factTree((numN + numM - 1).toBigInteger()) /
                (factTree(numM.toBigInteger()) * factTree((numN - 1).toBigInteger()))
    }

    private fun prodTree(l: BigInteger, r: BigInteger): BigInteger {
        if (l > r) return 1.toBigInteger()
        if (l == r) return l
        if (r - l == 1.toBigInteger()) return l * r
        val m = (l + r) / 2.toBigInteger()
        return prodTree(l, m) * prodTree(m + 1.toBigInteger(), r)
    }

    private fun factTree(n: BigInteger): BigInteger {
        if (n < 0.toBigInteger()) return 0.toBigInteger()
        if (n == 0.toBigInteger()) return 1.toBigInteger()
        return if (n == 1.toBigInteger() || n == 2.toBigInteger()) n else prodTree(2.toBigInteger(),
            n)
    }
}
