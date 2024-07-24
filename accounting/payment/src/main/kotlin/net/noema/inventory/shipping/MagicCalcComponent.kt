package net.noema.inventory

import org.springframework.stereotype.Component

@Component
class MagicCalcComponent {

    fun findMagicNumber(startFrom: Int = 9): Int {
        val addToIt = 9 - startFrom % 10
        var i = startFrom + addToIt
        var counter = 0
        while (true) {
            ++counter
            if (testMagicNumber(i)) {
                println(counter)
                return i
            }
            i += 10
        }
    }

    fun testMagicNumber(number: Int): Boolean {
        var i = 2
        while (i < 10) {
            if (number % i != i - 1) {
                return false
            }
            i++
        }
        return true
    }

}