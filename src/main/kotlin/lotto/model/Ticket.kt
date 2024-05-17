package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random
// Ticket 클래스 : 로또 숫자를 생성하는 메소드
class Ticket{
    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_SIZE = 6
    }
    // 로또 숫자를 생성하는 메소드 ( 리스트로 반환)
     fun generateLottoNumber(): List<Int>{
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).sorted()
    }
}