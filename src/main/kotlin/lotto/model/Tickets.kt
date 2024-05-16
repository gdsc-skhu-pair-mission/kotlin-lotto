package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Tickets(private val purchase: Purchase) {

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
        return Randoms.pickUniqueNumbersInRange(Ticket.MIN_NUMBER, Ticket.MAX_NUMBER, Ticket.LOTTO_SIZE).sorted()
    }

    private fun addTicket(ticket: List<Int>) {
        _lottoTickets.add(ticket)
    }
}
