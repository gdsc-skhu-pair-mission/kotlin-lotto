package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class Ticket {
    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }

    fun generateLottoNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).sorted()
    }
}
