package lotto.model

import lotto.util.Validator.validateAmount

class Purchase(private val amount: Int) {
    companion object {
        private const val LOTTO_PRICE = 1000
    }

    init {
        validateAmount(amount)
    }

    fun calculatePurchaseCount(): Int {
        return amount / LOTTO_PRICE
    }
}
