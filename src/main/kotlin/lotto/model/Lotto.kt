package lotto.model

import lotto.util.Validator.validateLottoDuplicate
import lotto.util.Validator.validateLottoRange
import lotto.util.Validator.validateLottoSize

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoSize(numbers)
        validateLottoRange(numbers)
        validateLottoDuplicate(numbers)
    }

    fun getWinningNumbers(): List<Int> {
        return numbers
    }
}
