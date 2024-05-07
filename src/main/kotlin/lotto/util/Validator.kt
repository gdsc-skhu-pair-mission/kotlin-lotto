package lotto.util

object Validator {
    private const val LOTTO_PRICE = 1000
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45
    private const val LOTTO_SIZE = 6

    fun validateInteger(input: String) {
        require(input.toIntOrNull() != null) {
            ErrorMessage.NUMBER_INTEGER.getMessage()
        }
    }

    fun validateNull(input: String) {
        require(input.trim().isNotEmpty()) {
            ErrorMessage.NUMBER_NULL.getMessage()
        }
    }

    fun validateNatural(input: String){
        require(input.trim().toInt() <= 0){
            ErrorMessage.NUMBER_NATURAL.getMessage()
        }
    }

    fun validateAmount(input: Int) {
        require(input % LOTTO_PRICE == 0) {
            ErrorMessage.AMOUNT_UNIT.getMessage()
        }
    }

    fun validateLottoRange(input: List<Int>) {
        input.forEach { validateRange(it) }
    }

    fun validateBonusRange(input: Int){
        validateRange(input)
    }

    private fun validateRange(input: Int) {
        require(input in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            ErrorMessage.LOTTO_RANGE.getMessage()
        }
    }

    fun validateLottoSize(input: List<Int>) {
        require(input.size == LOTTO_SIZE) {
            ErrorMessage.LOTTO_SIZE.getMessage()
        }
    }

    fun validateLottoDuplicate(input: List<Int>){
        require(input.distinct().size == LOTTO_SIZE){
            ErrorMessage.LOTTO_DUPLICATE.getMessage()
        }
    }

    fun validateLottoBonusDuplicate(numbers: List<Int>, bonus: Int){
        require(!numbers.contains(bonus)){
            ErrorMessage.BONUS_DUPLICATE.getMessage()
        }
    }
}
