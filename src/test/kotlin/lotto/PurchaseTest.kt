package lotto

import lotto.model.Purchase
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class PurchaseTest {
    @Test
    @DisplayName("구매 금액은 1,000원 단위여야 한다.")
    fun should_ThrowException_When_NotMultipleOfLottoPrice() {
        assertThrows<IllegalArgumentException> {
            Purchase(1001)
        }
    }

    @Test
    @DisplayName("구매 개수는 구매 금액을 로또 가격으로 나눈 것과 같아야 한다.")
    fun given_Amount_When_CalculatingPurchaseCount_Then_ResultEqualsExpectedPurchaseCount() {
        val amount = 8000
        val purchaseCount = 8
        val purchase = Purchase(amount)

        assertEquals(purchaseCount, purchase.calculatePurchaseCount())
    }
}
