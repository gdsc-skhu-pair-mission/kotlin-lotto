package lotto

import lotto.model.Bonus
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusTest {
    @Test
    @DisplayName("보너스 번호는 1부터 45 사이여야 한다.")
    fun should_ThrowException_When_OutOfRange() {
        assertThrows<IllegalArgumentException> {
            Bonus(46)
        }
    }

    @Test
    @DisplayName("보너스 번호는 당첨 번호와 중복되지 않아야 한다.")
    fun should_ThrowException_When_Duplicate() {
        assertThrows<IllegalArgumentException> {
            val bonus = Bonus(1)
            bonus.checkDuplicateWithLotto(listOf(1,2,3,4,5,6))
        }
    }
}
