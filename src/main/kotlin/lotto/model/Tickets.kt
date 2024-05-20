package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.dto.TicketsDTO

class Tickets(private val purchase: Purchase) {
    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_SIZE = 6
    }

    private val _lottoTickets: List<List<Int>> = generateTickets()

    val lottoTickets: List<List<Int>>
        get() = _lottoTickets

    fun convertToTicketsDTO(): TicketsDTO {
        return TicketsDTO(lottoTickets)
    }

    private fun generateTickets(): List<List<Int>> {
        return List(purchase.calculatePurchaseCount()) {
            generateLottoNumbers()
        }
    }

    private fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).sorted()
    }
}
