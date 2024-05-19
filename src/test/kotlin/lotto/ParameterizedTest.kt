package lotto

import lotto.model.Purchase
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class ParameterizedTest {
    private val inputInteger: Int = 10
    private val purchase = Purchase(1000)

    @Test
    @DisplayName("입력 값은 0이면 안 된다.")
    fun should_ThrowException_When_InputValue_Is_Zero() {
        assertFalse(inputInteger == 0)
    }

    //
    @Test
    @DisplayName("입력 값이 음수가 입력되서는 안 된다.")
    fun should_ThrowException_When_InputValue_Is_Nagative() {
        assertFalse(inputInteger <= 0)
    }

    @Test
    @DisplayName("구매 금액은 0보다 커야한다.")
    fun should_ThrowException_When_Purchase_Is_0() {
        assertFalse(purchase.purchaseAmount() == 0)
    }

    @Test
    @DisplayName("구매 금액은 음수여서는 안 된다.")
    fun should_ThrowException_When_Purchase_Is_Nagative() {
        assertFalse(purchase.purchaseAmount() < 0)
    }
}
