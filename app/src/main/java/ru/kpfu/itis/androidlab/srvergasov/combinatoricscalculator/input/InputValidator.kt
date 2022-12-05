package ru.kpfu.itis.androidlab.srvergasov.combinatoricscalculator.input

class InputValidator {
    private var msg = ""

    fun validateFun2(str1: String, str2: String): Boolean {
        if (str1.isEmpty()) {
            msg = "Пустое поле n"
            return false
        }
        if (str2.isEmpty()) {
            msg = "Пустое поле m"
            return false
        }
        return true
    }

    fun validatePermRep(str: String): Boolean {
        if (str.isEmpty()) {
            msg = "Пустое поле"
            return false
        }
        return try {
            val nums = mutableListOf<Int>()
            nums.addAll(str.split(",").map { el -> el.toInt() })
            true
        } catch (e: java.lang.NumberFormatException) {
            msg = "Некорректный формат"
            false
        }
    }

    fun validatePerm(str: String): Boolean {
        if (str.isEmpty()) {
            msg = "Пустое поле"
            return false
        }
        return true
    }

    fun getMessage() = msg

}