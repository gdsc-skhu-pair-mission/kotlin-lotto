package lotto.model

import lotto.util.Validator.validateBonusRange
import lotto.util.Validator.validateLottoBonusDuplicate

class Bonus (private val bonusNumber: Int){
    init {
        validateBonusRange(bonusNumber)
    }

    fun checkDuplicateWithLotto(numbers: List<Int>) {
        validateLottoBonusDuplicate(numbers, bonusNumber)
    }
}
