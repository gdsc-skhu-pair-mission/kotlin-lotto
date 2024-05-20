package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal

class Controller {
    fun start() {
        val purchase = inputPurchaseAmount()
        val tickets = generateLottoTickets(purchase)
        val lotto = inputWinningNumbers()
        val bonus = inputBonusNumber(lotto)
        val rank = calculateRank(tickets, lotto, bonus)
        showStatistics(rank)
        showEarningsRate(rank, purchase)
    }

    private fun inputPurchaseAmount(): Purchase {
        fun attemptInput(): Int {
            return tryGettingPurchaseAmount() ?: run {
                attemptInput()
            }
        }
        return Purchase(attemptInput())
    }

    private fun tryGettingPurchaseAmount(): Int? {
        return try {
            OutputView.printAmountMessage()
            InputView.getInteger()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            null
        }
    }

    private fun generateLottoTickets(purchase: Purchase): Tickets {
        OutputView.printPurchaseCountMessage(purchase.calculatePurchaseCount())
        val tickets = Tickets(purchase)
        val ticketsDTO = tickets.convertToTicketsDTO()
        OutputView.printTicketMessage(ticketsDTO.lottoTickets)
        return tickets
    }

    private fun inputWinningNumbers(): Lotto {
        fun attemptInput(): List<Int> {
            return tryGettingWinningNumbers() ?: run {
                attemptInput()
            }
        }
        return Lotto(attemptInput())
    }

    private fun tryGettingWinningNumbers(): List<Int>? {
        return try {
            OutputView.printWinningNumberMessage()
            InputView.getWinningNumber()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            null
        }
    }

    private fun inputBonusNumber(lotto: Lotto): Bonus {
        fun attemptInput(): Int {
            return tryGettingBonusNumber() ?: run {
                attemptInput()
            }
        }
        return Bonus(lotto, attemptInput())
    }

    private fun tryGettingBonusNumber(): Int? {
        return try {
            OutputView.printBonusNumberMessage()
            InputView.getInteger()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            null
        }
    }

    private fun calculateRank(tickets: Tickets, lotto: Lotto, bonus: Bonus): Rank {
        val rank = Rank(lotto, bonus)
        val ticketsDTO = tickets.convertToTicketsDTO()
        rank.calculateRank(ticketsDTO.lottoTickets)
        return rank
    }

    private fun showStatistics(rank: Rank) {
        val rankDTO = rank.convertToRankDTO()
        OutputView.printStatistics(rankDTO.rankList)
    }

    private fun showEarningsRate(rank: Rank, purchase: Purchase) {
        val prize = Prize(rank, purchase)
        val prizeRate = prize.getRate(prize.getPrizeMoney())
        OutputView.printEarningsRate(prizeRate)
    }
}
