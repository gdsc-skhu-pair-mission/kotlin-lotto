package lotto.controller

import lotto.model.Purchase
import lotto.model.Ticket

// 티켓을 관리하는 컨트롤러
class TicketController() {

    var ticket = Ticket()
    var tickets: MutableList<List<Int>> = mutableListOf()

    // 개수만큼 티켓을 만드는 메소드
    fun generateTickets(purchase: Purchase): List<List<Int>> {
        repeat(purchase.calculatePurchaseCount()) {
            val ticket = ticket.generateLottoNumber()
            //       ticket = ticket.generateLottoNumber()
            addTicket(ticket)
        }
        return tickets
    }

    // tickets에 ticket을 추가하는 메소드
    fun addTicket(ticket: List<Int>) {
        tickets.add(ticket)
    }
}
