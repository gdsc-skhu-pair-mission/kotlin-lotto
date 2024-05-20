package lotto

import lotto.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PrizeTest {
    private val lotto = Lotto(listOf(1,2,3,4,5,6))
    private val bonus = Bonus(lotto, 7)

    private val tickets = listOf(listOf(1,2,3,7,8,9), listOf(1,2,3,4,10,11), listOf(11,12,13,14,15,16), listOf(17,18,19,20,21,22), listOf(23,24,25,26,27,28))

    private val rank = Rank(lotto, bonus)
    private val purchase = Purchase(5000)
    private val prize = Prize(rank, purchase)

    @Test
    @DisplayName("당첨 순위에 따른 올바른 금액을 반환한다.")
    fun when_given_rank_then_returnCorrectPrizeMoney() {
        rank.calculateRank(tickets)
        val prizeMoney = prize.getPrizeMoney()
        val expectedPrizeMoney = 55000
        assertEquals(prizeMoney, expectedPrizeMoney)
    }

    @Test
    @DisplayName("당첨 금액에 따른 올바른 수익률을 반환한다.")
    fun when_given_prize_then_returnCorrectRate() {
        rank.calculateRank(tickets)
        val rate = prize.getRate(prize.getPrizeMoney())
        val expectedRate = "1100.0"
        assertEquals(rate, expectedRate)
    }
}
