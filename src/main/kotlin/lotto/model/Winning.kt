package lotto.model

class Winning(private val lottoNumbers: List<Int>, private val bonusNumber: Int) {
    private var _winningTickets: MutableList<List<Int>> = mutableListOf()
    private val winningTickets: List<List<Int>>
        get() = _winningTickets.toList()

    init {
        _winningTickets.add(lottoNumbers)
    }

    fun compareOfTickets(tickets: Tickets) {
        countOfNumber(lottoNumbers, tickets.generateTickets())
    }

    fun ticketsWithBonus(tickets: Tickets): Boolean {
        return tickets.generateTickets().any { ticket -> bonusNumber in ticket }
    }

    private fun countOfNumber(lottoNumbers: List<Int>, ticketNumbers: List<List<Int>>): Int {
        var sumOfCount =  ticketNumbers.sumOf { ticket -> lottoNumbers.count { it in ticket } }
        return sumOfCount
    }
}
