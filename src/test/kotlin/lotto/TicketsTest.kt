package lotto

import lotto.model.Purchase
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class TicketsTest {
    private val purchase = Purchase(3000)
    private val tickets = Tickets(purchase)
    private val ticketsList = tickets.generateTickets()

    @Test
    @DisplayName("각 로또의 로또 번호는 6개씩 생성되어야 한다.")
    fun generateTickets_EachTicketContainNumbersEqualToLOTTO_SIZE() {
        assertTrue(ticketsList.all { it.size == 6 })
    }

    @Test
    @DisplayName("각 로또의 로또 번호는 1부터 45 사이의 숫자여야 한다.")
    fun generateTickets_NumbersInEachTicketsShouldBeBetween1And45() {
        assertTrue(ticketsList.all { it -> it.all { it in 1..45 }})
    }

    @Test
    @DisplayName("로또는 구입 개수만큼 생성되어야 한다.")
    fun given_purchaseCount_When_generateTickets_Then_ResultEqualsExpectedTicketsCount() {
        assertEquals(purchase.calculatePurchaseCount(), ticketsList.size)
    }
}
