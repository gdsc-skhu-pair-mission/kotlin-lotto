package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Tickets(private val purchase: Purchase) {
    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_SIZE = 6
    }

    private var _lottoTickets: MutableList<List<Int>> = mutableListOf()

    val lottoTickets: List<List<Int>>
        get() = _lottoTickets.toList()

    fun generateTickets(): List<List<Int>> {
        repeat(purchase.calculatePurchaseCount()) {
            val ticket = generateLottoNumbers()
            addTicket(ticket)
        }
        return lottoTickets
    }

    private fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).sorted()
    }

    private fun addTicket(ticket: List<Int>) {
        _lottoTickets.add(ticket)
    }
}
