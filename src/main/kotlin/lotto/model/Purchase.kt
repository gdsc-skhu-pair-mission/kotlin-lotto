package lotto.model

import lotto.util.Validator.validateAmount

class Ticket(private val amount: Int) {
    init {
        validateAmount(amount)
    }
}
