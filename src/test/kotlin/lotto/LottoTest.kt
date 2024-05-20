package lotto

import lotto.model.Lotto
import net.bytebuddy.pool.TypePool.Resolution.Illegal
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class LottoTest {
    @Test
    @DisplayName("로또 번호는 중복되지 않아야 한다.")
    fun should_throwException_when_duplicate() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    @DisplayName("로또 번호는 1부터 45 사이여야 한다.")
    fun should_throwException_when_outOfRange() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 45, 46))
        }
    }

    @Test
    @DisplayName("로또 번호는 6개여야 한다.")
    fun should_throwException_when_outOfSize() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
    }
}
