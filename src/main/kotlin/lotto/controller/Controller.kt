package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView

class Controller {
    private val ticketController = TicketController()
    private val tickets = ticketController.handleTicketPurchase()

    fun start() {
        tickets
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        val rank = calculateRank(tickets, winningNumbers, bonusNumber)
        printStatistics(rank)
        printEarningsRate(rank, ticketController.purchaseAmout)
    }

    private fun inputWinningNumbers(): List<Int> {
        while (true) {
            try {
                OutputView.printWinningNumberMessage()
                return InputView.getWinningNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(): Int {
        while (true) {
            try {
                OutputView.printBonusNumberMessage()
                return InputView.getInteger()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun calculateRank(lottoTickets: List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int): Rank {
        val lotto = Lotto(winningNumbers)
        val bonus = Bonus(lotto, bonusNumber)
        val rank = Rank(lotto, bonus)
        rank.calculateRank(lottoTickets)
        return rank
    }

    private fun printStatistics(rank: Rank) {
        OutputView.printStatistics(rank.rankList)
    }

    private fun printEarningsRate(rank: Rank, purchaseAmount: Int?) {
        val prize = Prize(rank)
        val prizeRate = prize.getRate(prize.getPrizeMoney(), purchaseAmount!!)
        OutputView.printEarningsRate(prizeRate)
    }
}
