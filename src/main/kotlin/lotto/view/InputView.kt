package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator.validateInteger
import lotto.util.Validator.validateNatural
import lotto.util.Validator.validateNull

object InputView {
    private const val SEPARATOR = ","

    private fun getUserInput(): String = Console.readLine()

    fun getInteger(): Int {
        val input = getUserInput()
        validateNull(input)
        validateInteger(input)
        validateNatural(input)
        return input.toInt()
    }

    fun getWinningNumber(): List<Int> {
        val winningNumber = getUserInput()
        validateNull(winningNumber)
        return winningNumber.split(SEPARATOR).map {
            validateInteger(it)
            validateNatural(it)
            it.toInt()
        }
    }
}
