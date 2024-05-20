package lotto.model

import lotto.util.Validator.validateBonusRange
import lotto.util.Validator.validateLottoBonusDuplicate

class Bonus (
    private val lotto: Lotto,
    private val _bonusNumber: Int
) {

    val bonusNumber: Int
        get() = _bonusNumber

    init {
        validateBonusRange(_bonusNumber)
        validateLottoBonusDuplicate(lotto.getWinningNumbers(), _bonusNumber)
    }
}
