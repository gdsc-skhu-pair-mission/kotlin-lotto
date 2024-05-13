package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RankingTest {

    val winningTest = WinningTest()
    var ranking = 0

    @Test
    @DisplayName("ranking과 순위가 일치해야한다.")
    fun isCorrect() {
        assertTrue(ranking_1st() == 1)
        assertTrue(ranking_2nd()==2)
        assertTrue(ranking_3rd() == 3)
        assertTrue(ranking_4rd() == 4)
        assertTrue(ranking_5rd() == 5)

    }

    @Test
    @DisplayName("당첨 번호와 로또 번호가 전부 일치할 때, 당첨 결과는 1등이다")
    fun ranking_1st(): Int {
        if (winningTest.should_ThrowTrue_When_Correct_With_6() == 6) {
            ranking = 1
        }
        return ranking
    }

    @Test
    @DisplayName("당첨 번호에 보너스 번호 포함할 때, 로또 번호가 전부 일치할 때, 당첨 결과는 2등이다")
    fun ranking_2nd(): Int {
        if (winningTest.should_ThrowTrue_When_Correct_WithBonus() == 6) {
            ranking = 2
        }
        return ranking
    }


    @Test
    @DisplayName("당첨 번호, 보너스 번호와 로또 번호가 5개 일치할 때, 당첨 결과는 3등이다")
    fun ranking_3rd(): Int {
        if (winningTest.should_ThrowTrue_When_Correct_With_5() == 5) {
            ranking = 3
        }
        return ranking
    }

    @Test
    @DisplayName("당첨 번호, 보너스 번호와 로또 번호가 4개 일치할 때, 당첨 결과는 4등이다")
    fun ranking_4rd(): Int {
        if (winningTest.should_ThrowTrue_When_Correct_With_4() == 4) {
            ranking = 4
        }
        return ranking
    }

    @Test
    @DisplayName("당첨 번호, 보너스 번호와 로또 번호가 3개 일치할 때, 당첨 결과는 5등이다")
    fun ranking_5rd(): Int {
        if (winningTest.should_ThrowTrue_When_Correct_With_3() == 3) {
            ranking = 5
        }
        return ranking
    }
}


