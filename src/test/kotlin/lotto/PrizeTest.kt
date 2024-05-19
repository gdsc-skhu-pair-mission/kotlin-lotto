package lotto

import lotto.controller.TicketController
import lotto.model.Bonus
import lotto.model.Lotto
import lotto.model.Prize
import lotto.model.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class PrizeTest {

    lateinit var lotto :Lotto
    lateinit var bonus:Bonus
    val tickets =  listOf(listOf(1,2,3,7,8,9), listOf(1,2,3,4,10,11), listOf(11,12,13,14,15,16), listOf(17,18,19,20,21,22), listOf(23,24,25,26,27,28))


    lateinit var rank:Rank
    lateinit var prize: Prize
    @BeforeEach
    fun setUp() {
        lotto = Lotto(listOf(1,2,3,4,5,6))
        bonus = Bonus(lotto, 7)
        rank =  Rank(lotto, bonus)
        prize = Prize(rank)

    }
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

    @Test
    @DisplayName("수익률은 0.0 이상이어야한다.")
    fun should_ThrowException_When_CorrectRate(){
        rank.calculateRank((tickets))
        val prizeMoney = prize.getPrizeMoney()
        val rate = prize.getRate(prizeMoney, 5000)
        assertThrows<IllegalArgumentException> {
            if (rate.toDouble() > 0.0) {
                throw IllegalArgumentException("수익률은 0.0 이상이어야 한다.")
            }
        }

    }
}
