package lotto.controller

import lotto.model.Purchase
import lotto.model.Ticket
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.OutputView.printTicketMessage

class TicketController() {

    private var ticket = Ticket()
    private var tickets: MutableList<List<Int>> = mutableListOf()
    var purchaseAmout: Int? = null

    fun handleTicketPurchase(): List<List<Int>> {
        purchaseAmout = inputPurchaseAmount()
        tickets = generateTickets(purchaseAmout!!)
        printTicketMessage(this.tickets)
        return tickets
    }

    private fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                OutputView.printAmountMessage()
                //   purchaseAmount = InputView.getInteger()
                return InputView.getInteger()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun generateTickets(purchaseAmount: Int): MutableList<List<Int>> {
        val purchase = Purchase(purchaseAmount)
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
