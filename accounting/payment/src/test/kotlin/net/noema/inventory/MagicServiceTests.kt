package net.noema.inventory

import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MagicServiceTests {

    @SpyK
    var magicCalc: MagicCalcComponent = MagicCalcComponent()

    @InjectMockKs
    lateinit var magicService: MagicService

    @Test
    fun `find the first magic number`() {
        val result = magicService.findMagicNumber(1000)
        verify(atMost = 252) { magicCalc.testMagicNumber(any()) }
        assert(magicCalc.testMagicNumber(result))
    }

    @Test
    fun `test testMagicNumber`(){
        assert(magicCalc.testMagicNumber(2519))
    }


}