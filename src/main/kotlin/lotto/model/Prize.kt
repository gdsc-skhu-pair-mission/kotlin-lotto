package lotto.model

class Prize(
    private val rank: Rank,
    private val purchase: Purchase
) {
    companion object {
        private const val PRIZE_1ST = 2_000_000_000
        private const val PRIZE_2ND = 30_000_000
        private const val PRIZE_3RD = 1_500_000
        private const val PRIZE_4TH = 50_000
        private const val PRIZE_5TH = 5_000

        private const val PERCENT = 100
    }

    fun getPrizeMoney(): Int {
        return rank.rankList[0] * PRIZE_1ST + rank.rankList[1] * PRIZE_2ND +
                rank.rankList[2] * PRIZE_3RD + rank.rankList[3] * PRIZE_4TH + rank.rankList[4] * PRIZE_5TH
    }

    fun getRate(prizeMoney: Int): String {
        val rate = (prizeMoney.toDouble() / purchase.amount.toDouble()) * PERCENT
        return String.format("%.1f", rate)
    }
}
