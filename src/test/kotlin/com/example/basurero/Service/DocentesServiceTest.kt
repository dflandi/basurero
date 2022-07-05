package com.example.basurero.Service

import com.example.basurero.model.Docentes
import com.example.basurero.repository.DocentesRepository
import com.example.basurero.service.DocentesService

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File


@SpringBootTest
class DocentesServiceTest {

   /* @InjectMocks
    lateinit var docentesService: DocentesService*/

    /*@Mock
    lateinit var docentesRepository: DocentesRepository*/
    @Autowired
    lateinit var docentesService:DocentesService


    /*final val jsonString = File("./src/test/resources/product.json").readText(Charsets.UTF_8)
    val docentesMock = Gson().fromJson(jsonString, Docentes::class.java)*/

    /*@Test
    fun saveProduct(){
        //PAra actualizar
        /// LLAVES  FORENEAS
        //Mockito.`when`(productRepository.findById(productMock.id)).thenReturn(productMock)
        Mockito.`when`(docentesRepository.save(Mockito.any(Docentes::class.java))).thenReturn(docentesMock)
        val response = docentesService.save(docentesMock)
        Assertions.assertEquals(response?.id, docentesMock.id)
    }

    @Test
    fun saveProductFailed(){
        Assertions.assertThrows(Exception::class.java) {
            docentesMock.apply { nombre=" "}
            Mockito.`when`(docentesRepository.save(Mockito.any(Docentes::class.java))).thenReturn(docentesMock)
            docentesService.save(docentesMock)
        }
    }*/


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
    @Test
    fun validateDecenaSupCuandoEsCero(){
        val response=docentesService.findDecenaSuperior(20)
        Assertions.assertEquals(0, response)
    }
    @Test
    fun validateDecenaSupCuandoNoEsCero(){
        val response=docentesService.findDecenaSuperior(13)
        Assertions.assertEquals(7, response)
    }
    @Test
    fun validarCedulaValida(){
        val response=docentesService.ultimoDigito("34")
        Assertions.assertEquals(4, response)
    }
    @Test
    fun validarCedulaNoEsValida(){
        val response=docentesService.findDecenaSuperior(13)
        Assertions.assertEquals(7, response)
    }
    @Test
    fun  testUltimoDigito(){
        val response = docentesService.ultimoDigito("0107201915")
        Assertions.assertEquals(5,response)
    }
    @Test
    fun validarTotales(){
        val response= docentesService.validarTotal("0107201915")
        Assertions.assertEquals(true, response)
    }



}