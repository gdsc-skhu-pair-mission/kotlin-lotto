package lotto.model

class Rank(
    private val lotto: Lotto,
    private val bonus: Bonus,
) {
    private val _rankList: MutableList<Int> = MutableList(6) { 0 }

    val rankList: List<Int>
        get() = _rankList

    companion object {
        private const val INDEX_1ST = 0
        private const val INDEX_2ND = 1
        private const val INDEX_3RD = 2
        private const val INDEX_4TH = 3
        private const val INDEX_5TH = 4
        private const val INDEX_NONE = 5

        private const val COUNT_SIX = 6
        private const val COUNT_FIVE = 5
        private const val COUNT_FOUR = 4
        private const val COUNT_THREE = 3
    }

    fun calculateRank(tickets: List<List<Int>>) {
        val winningNumbers = lotto.getWinningNumbers()
        val bonusNumber = bonus.bonusNumber

        tickets.forEach { ticket ->
            val matchCount = ticket.count { it in winningNumbers }
            val rankIndex = getRankIndex(matchCount, ticket.contains(bonusNumber))
            _rankList[rankIndex]++
        }
    }

    private fun getRankIndex(matchCount: Int, hasBonus: Boolean): Int {
        if (matchCount == COUNT_SIX) return INDEX_1ST
        if (matchCount == COUNT_FIVE) return countBonus(hasBonus)
        if (matchCount == COUNT_FOUR) return INDEX_4TH
        if (matchCount == COUNT_THREE) return INDEX_5TH
        return INDEX_NONE
    }

    private fun countBonus(hasBonus: Boolean): Int {
        if(hasBonus) return INDEX_2ND
        return INDEX_3RD
    }
}
