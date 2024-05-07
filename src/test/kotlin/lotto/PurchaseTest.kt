package lotto

import lotto.model.Bonus
import lotto.model.Purchase
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseTest {
    @Test
    @DisplayName("로또 금액은 1,000원 단위여야 한다.")
    fun should_ThrowException_When_NotMultipleOfLottoPrice() {
        assertThrows<IllegalArgumentException> {
            Purchase(1001)
        }
    }
}
