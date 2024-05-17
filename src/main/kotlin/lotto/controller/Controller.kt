package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView
import lotto.view.OutputView.printPurchaseCountMessage
import lotto.view.OutputView.printTicketMessage

class Controller {
    private val ticketController = TicketController()

    // 시작하는 컨트롤러
    fun start() {
        val purchaseAmount = inputPurchaseAmount()
        generateLottoTickets(purchaseAmount)

        val winningNumbers = inputWinningNumbers()
        val bonusNumber = inputBonusNumber()
        val rank = calculateRank(ticketController.tickets, winningNumbers, bonusNumber)
        printStatistics(rank)
        printEarningsRate(rank, purchaseAmount)
    }

    // 개수를 입력하는 메소드
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

    // 수량 만큼 로또 티켓들을 만드는 메소드
    private fun generateLottoTickets(purchaseAmount: Int): List<List<Int>> {
        val purchase = Purchase(purchaseAmount)
        OutputView.printPurchaseCountMessage(purchase.calculatePurchaseCount())
        //    val tickets = Tickets(purchase)
        val tickets = ticketController.generateTickets(purchase)
        // val lottoTickets = ticketControler.generateTickets()
        OutputView.printTicketMessage(ticketController.tickets)
        return tickets
    }

    // 당첨 번호 입력하는 메소드
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

    // 보너스 번호 입력하는 메소드
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

    // 순위 계산하는 메소드
    private fun calculateRank(lottoTickets: List<List<Int>>, winningNumbers: List<Int>, bonusNumber: Int): Rank {
        val lotto = Lotto(winningNumbers)
        val bonus = Bonus(lotto, bonusNumber)
        val rank = Rank(lotto, bonus)
        rank.calculateRank(lottoTickets)
        return rank
    }

    // 현재 랭크 출력하는 메소드
    private fun printStatistics(rank: Rank) {
        OutputView.printStatistics(rank.rankList)
    }

    // 수익률을 출력하는 메소드
    private fun printEarningsRate(rank: Rank, purchaseAmount: Int) {
        val prize = Prize(rank)
        val prizeRate = prize.getRate(prize.getPrizeMoney(), purchaseAmount)
        OutputView.printEarningsRate(prizeRate)
    }
}
