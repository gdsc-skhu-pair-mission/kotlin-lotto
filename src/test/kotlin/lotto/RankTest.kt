package lotto

import lotto.model.Bonus
import lotto.model.Lotto
import lotto.model.Rank
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.math.exp

class RankTest {
    private val lotto = Lotto(listOf(1,2,3,4,5,6))
    private val bonus = Bonus(lotto,7)
    private val rank = Rank(lotto, bonus)

    @Test
    @DisplayName("모든 번호가 일치할 때 1등을 반환한다.")
    fun calculateRank_WithAllMatchingNumbers_ReturnFirstRank() {
        val ticket = listOf(listOf(1,2,3,4,5,6))
        rank.calculateRank(ticket)
        val expectedRankList = listOf(1,0,0,0,0,0)
        assertEquals(rank.rankList, expectedRankList)
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호가 일치할 때 2등을 반환한다.")
    fun calculateRank_WithFiveMatchingNumbersAndBonus_ReturnSecondRank() {
        val ticket = listOf(listOf(1,2,3,4,5,7))
        rank.calculateRank(ticket)
        val expectedRankList = listOf(0,1,0,0,0,0)
        assertEquals(rank.rankList, expectedRankList)
    }

    @Test
    @DisplayName("5개의 번호가 일치할 때 3등을 반환한다.")
    fun calculateRank_WithFiveMatchingNumbers_ReturnThirdRank() {
        val ticket = listOf(listOf(1,2,3,4,5,8))
        rank.calculateRank(ticket)
        val expectedRankList = listOf(0,0,1,0,0,0)
        assertEquals(rank.rankList, expectedRankList)
    }

    @Test
    @DisplayName("4개의 번호가 일치할 때 4등을 반환한다.")
    fun calculateRank_WithFourMatchingNumbers_ReturnFourthRank() {
        val ticket = listOf(listOf(1,2,3,4,8,9))
        rank.calculateRank(ticket)
        val expectedRankList = listOf(0,0,0,1,0,0)
        assertEquals(rank.rankList, expectedRankList)
    }

    @Test
    @DisplayName("3개의 번호가 일치할 때 5등을 반환한다.")
    fun calculateRank_WithThreeMatchingNumbers_ReturnFifthRank() {
        val ticket = listOf(listOf(1,2,3,8,9,10))
        rank.calculateRank(ticket)
        val expectedRankList = listOf(0,0,0,0,1,0)
        assertEquals(rank.rankList, expectedRankList)
    }

    @Test
    @DisplayName("3개 미만의 번호가 일치할 때 순위에 해당하지 않음을 반환한다.")
    fun calculateRank_WithUnderThreeMatchingNumbers_ReturnNoRank() {
        val ticket = listOf(listOf(1,2,8,9,10,11))
        rank.calculateRank(ticket)
        val expectedRankList = listOf(0,0,0,0,0,1)
        assertEquals(rank.rankList, expectedRankList)
    }
}
