package lotto

import lotto.model.Bonus
import lotto.model.Lotto
import lotto.model.Prize
import lotto.model.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PrizeTest {
    private val lotto = Lotto(listOf(1,2,3,4,5,6))
    private val bonus = Bonus(lotto, 7)

    private val tickets = listOf(listOf(1,2,3,7,8,9), listOf(1,2,3,4,10,11), listOf(11,12,13,14,15,16), listOf(17,18,19,20,21,22), listOf(23,24,25,26,27,28))

    private val rank = Rank(lotto, bonus)
    private val prize = Prize(rank)

    @Test
    @DisplayName("당첨 순위에 따른 올바른 금액을 반환한다.")
    fun when_Given_Rank_Then_ReturnCorrectPrizeMoney() {
        rank.calculateRank(tickets)
        val prizeMoney = prize.getPrizeMoney()
        val expectedPrizeMoney = 55000
        assertEquals(prizeMoney, expectedPrizeMoney)
    }

    @Test
    @DisplayName("당첨 금액에 따른 올바른 수익률을 반환한다.")
    fun when_Given_Prize_Then_ReturnCorrectRate() {
        rank.calculateRank(tickets)
        val prizeMoney = prize.getPrizeMoney()
        val rate = prize.getRate(prizeMoney, 5000)
        val expectedRate = "1100.0"
        assertEquals(rate, expectedRate)
    }
}
