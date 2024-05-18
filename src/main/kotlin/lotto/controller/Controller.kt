package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.OutputView.printPurchaseCountMessage
import lotto.view.OutputView.printTicketMessage

class Controller {
    private val ticketController = TicketController()
    private val purchaseAmount = inputPurchaseAmount()
    fun start() {
        purchaseController()
        inputWinningNumberCountroller()
    }

    fun purchaseController() : List<List<Int>> {
        val purchaseAmount = purchaseAmount
        val tickets =  generateLottoTickets(purchaseAmount)
        return tickets
    }
    fun inputWinningNumberCountroller() {
        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        rankController(purchaseController(), winningNumbers, bonusNumber )
    }
    fun rankController(tickets : List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int) {
        val rank = calculateRank(tickets, winningNumbers, bonusNumber)
        printStatistics(rank)
        printEarningsRate(rank, purchaseAmount)
    }

    private fun inputPurchaseAmount(): Int {
        while (true) {
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
        printPurchaseCountMessage(purchase.calculatePurchaseCount())
        val tickets = ticketController.generateTickets(purchase)
        printTicketMessage(ticketController.tickets)
        return tickets
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

    private fun printEarningsRate(rank: Rank, purchaseAmount: Int) {
        val prize = Prize(rank)
        val prizeRate = prize.getRate(prize.getPrizeMoney(), purchaseAmount)
        OutputView.printEarningsRate(prizeRate)
    }
}
