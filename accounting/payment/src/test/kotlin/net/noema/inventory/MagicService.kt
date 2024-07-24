package net.noema.inventory

class MagicService(
    private val magicCalc: MagicCalcComponent
) {

    fun findMagicNumber(startFrom: Int = 1) = magicCalc.findMagicNumber(startFrom)

}