package lotto.model

import lotto.util.Validator.validateAmount

class Purchase(private val price: Int) {
    init {
        validateAmount(price)
    }
}
