package com.example.basurero.Service

import com.example.basurero.service.DocentesService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class DocentesServiceTest {

    @Autowired
    lateinit var docentesService: DocentesService

    @Test
    fun validateSerialIsValid(){
        val response =  docentesService.validateSerialNumber("786456789")
        Assertions.assertEquals(true,response)
    }
    @Test
    fun validateSerialIsInvalid(){
        val response =  docentesService.validateSerialNumber("2121544")
        Assertions.assertEquals(false,response)
    }

    @Test
    fun validateSerialIsBlank() {
        Assertions.assertThrows(Exception::class.java) {
            val response = docentesService.validateSerialNumber("")
        }
    }
    @Test
    fun validateSerialIsIncomplete() {
        Assertions.assertThrows(Exception::class.java) {
            val response = docentesService.validateSerialNumber("5")
        }
    }
    @Test
    fun multi(){
        val response = docentesService.multi(1, 7)
        Assertions.assertEquals(7, response)
    }
    @Test
    fun multiOfCoeAndDigito(){
        val response = docentesService.multi(2, 7)
        Assertions.assertEquals(5, response)
    }
    @Test
    fun validateSumaNui(){
        val response=docentesService.sumaValores("0301707030")
        Assertions.assertEquals(20, response)
    }


}