package lotto.controller

import lotto.model.Purchase
import lotto.model.Ticket

class TicketController() {

    private var ticket = Ticket()
    var tickets: MutableList<List<Int>> = mutableListOf()

    fun generateTickets(purchase: Purchase): List<List<Int>> {
        repeat(purchase.calculatePurchaseCount()) {
            val ticket = ticket.generateLottoNumber()
            addTicket(ticket)
        }
        return tickets
    }

    private fun addTicket(ticket: List<Int>) {
        tickets.add(ticket)
    }
}
