package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class WinningTest {

    val lotto = arrayOf(1, 2, 3, 4, 5, 6)
    val bonus = arrayOf(7)
    val winningTicket = arrayOf(lotto, bonus)
    lateinit var ticket: MutableList<Int>

    @Test
    @DisplayName("개수가 일치하도록 반환되는지 확인되어야한다.")
    fun isCorrect() {
        assertTrue(should_ThrowTrue_When_Correct_With_6() == 6)
        assertTrue(should_ThrowTrue_When_Correct_WithBonus() == 6)
        assertTrue(should_ThrowTrue_When_Correct_With_5() == 5)
        assertTrue(should_ThrowTrue_When_Correct_With_4() == 4)
        assertTrue(should_ThrowTrue_When_Correct_With_3() == 3)
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 모두 일치할 때 6이 반환되어야 한다.")
    fun should_ThrowTrue_When_Correct_With_6(): Int {
        var count: Int = 0;
        var score: Int = 0
        ticket = mutableListOf(1, 2, 3, 4, 5, 6)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        score = count
        return score
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 모두 일치할 때 6개가 반환되지 않으면, 예외가 발생한다.")
    fun should_ThrowExeption_When_Discord() {
        var count: Int = 0
        ticket = mutableListOf(1, 2, 3, 4, 5, 7)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        assertThrows<IllegalArgumentException> {
            if (count != 6) throw IllegalArgumentException()
        }
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호 5개, 보너스 번호 1개가 일치할 때, 6이 반환되어야한다.")
    fun should_ThrowTrue_When_Correct_WithBonus(): Int {
        var count: Int = 0;
        var score: Int = 0
        ticket = mutableListOf(1, 2, 3, 4, 5, 7)

        repeat(winningTicket[0].size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        repeat(ticket.size) { index ->
            if (winningTicket[1].contains(ticket[index])) {
                count++
            }
        }

        score = count
        return score
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호 5개, 보너스 번호 1개가 일치할 때, 6이 반환되지 않으면, 예외가 발생한다.")
    fun should_ThrowExeption_When_Discord_WithBonus() {
        var count: Int = 0
        ticket = mutableListOf(1, 2, 3, 4, 5, 6, 7)

        repeat(winningTicket[0].size) { index ->
            if (winningTicket[0].contains(ticket[index])) {
                count++
            }

        }
        repeat(ticket.size) { index ->
            if (winningTicket[1].contains(ticket[index])) {
                count++
            }
        }
        assertThrows<IllegalArgumentException> {
            if (count != 6) throw IllegalArgumentException()
        }
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 5개 일치할 때, 5가 반환되어야 한다.")
    fun should_ThrowTrue_When_Correct_With_5(): Int {
        var count: Int = 0;
        var score: Int = 0
        ticket = mutableListOf(1, 2, 3, 4, 5, 8)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        score = count

        return score
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 5개 일치할 때 5가 반환되지 않으면, 예외가 발생한다.")
    fun should_ThrowExeption_When_Discord_With_5() {
        var count: Int = 0
        ticket = mutableListOf(1, 2, 3, 4, 7, 8)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        assertThrows<IllegalArgumentException> {
            if (count != 5) throw IllegalArgumentException()
        }
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 4개 일치할 때, 4가 반환되어야 한다.")
    fun should_ThrowTrue_When_Correct_With_4(): Int {
        var count: Int = 0;
        var score: Int = 0
        ticket = mutableListOf(1, 2, 4, 5, 7, 8)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        score = count

        return score
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 4개 일치할 때 4가 반환되지 않으면, 예외가 발생한다.")
    fun should_ThrowExeption_When_Discord_With_4() {
        var count: Int = 0
        ticket = mutableListOf(1, 2, 3, 7, 8, 9)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        assertThrows<IllegalArgumentException> {
            if (count != 4) throw IllegalArgumentException()
        }
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호, 보너스 번호가 3개 일치할 때, 3이 반환되어야 한다.")
    fun should_ThrowTrue_When_Correct_With_3(): Int {
        var count: Int = 0;
        var score: Int = 0
        ticket = mutableListOf(1, 2, 3, 7, 8, 9)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        score = count

        return score
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호가 3개 일치할 때 3이 반환되지 않으면, 예외가 발생한다.")
    fun should_ThrowExeption_When_Discord_With_3() {
        var count: Int = 0
        ticket = mutableListOf(1, 2, 7, 8, 9, 10)

        repeat(lotto.size) { index ->
            if (lotto.contains(ticket[index])) {
                count++
            }
        }
        assertThrows<IllegalArgumentException> {
            if (count != 3) throw IllegalArgumentException()
        }
    }

}
