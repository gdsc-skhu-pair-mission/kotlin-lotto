package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView

class Controller {
    fun start() {
        val purchaseAmount = inputPurchaseAmount()
        val tickets = generateLottoTickets(purchaseAmount)
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        val rank = calculateRank(tickets, winningNumbers, bonusNumber)
        printStatistics(rank)
        printEarningsRate(rank, purchaseAmount)
    }

    private fun inputPurchaseAmount(): Int {
        while(true) {
            try {
                OutputView.printAmountMessage()
                return InputView.getInteger()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateLottoTickets(purchaseAmount: Int): List<List<Int>> {
        val purchase = Purchase(purchaseAmount)
        OutputView.printPurchaseCountMessage(purchase.calculatePurchaseCount())
        val tickets = Tickets(purchase)
        val lottoTickets = tickets.generateTickets()
        OutputView.printTicketMessage(lottoTickets)
        return lottoTickets
    }

    private fun inputWinningNumbers(): List<Int> {
        while(true) {
            try {
                OutputView.printWinningNumberMessage()
                return InputView.getWinningNumber()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(): Int {
        while(true) {
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

    private fun printEarningsRate(rank: Rank, purchaseAmount: Int) {
        val prize = Prize(rank)
        val prizeRate = prize.getRate(prize.getPrizeMoney(), purchaseAmount)
        OutputView.printEarningsRate(prizeRate)
    }

}
