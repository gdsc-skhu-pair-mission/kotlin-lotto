package lotto.model

import lotto.util.Validator.validateBonusRange
import lotto.util.Validator.validateLottoBonusDuplicate

class Bonus (
    private val lotto: Lotto,
    private val bonusNumber: Int
) {
    init {
        validateBonusRange(bonusNumber)
    }

    fun checkDuplicateWithLotto() {
        validateLottoBonusDuplicate(lotto.getWinningNumbers(), bonusNumber)
    }
}
