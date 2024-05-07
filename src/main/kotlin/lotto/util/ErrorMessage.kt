package lotto.util

enum class ErrorMessage(private val message: String) {
    NUMBER_NULL("입력값이 존재하지 않습니다."),
    NUMBER_INTEGER("입력값은 숫자여야 합니다."),
    NUMBER_NATURAL("입력값은 자연수여야 합니다."),
    AMOUNT_UNIT("구매 금액은 1000원 단위로 입력되어야 합니다."),
    LOTTO_RANGE("로또 번호의 숫자 범위는 1~45 사이여야 합니다."),
    LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE("당첨 번호는 각기 다른 수를 입력해야 합니다."),
    BONUS_DUPLICATE("보너스 번호는 당첨 번호와 중복되어서는 안됩니다.");

    fun getMessage(): String = "[ERROR] $message"
}
