package lotto.model

import lotto.util.Validator.validateAmount

class Purchase(private val _amount: Int) {
    companion object {
        private const val LOTTO_PRICE = 1000
    }

    init {
        validateAmount(_amount)
    }

    val amount: Int
        get() = _amount

    fun calculatePurchaseCount(): Int {
        return _amount / LOTTO_PRICE
    }
}
