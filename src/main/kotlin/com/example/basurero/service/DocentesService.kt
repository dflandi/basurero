package com.example.basurero.service;
import com.example.basurero.model.Docentes
import com.example.basurero.repository.DocentesRepository
import com.example.basurero.repository.PadresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DocentesService {
    @Autowired
    lateinit var docentesRepository: DocentesRepository
    @Autowired
    lateinit var padresRepository: PadresRepository


    fun list() : List<Docentes> {
        return docentesRepository.findAll()
        }

    fun save(camion: Docentes):Docentes{
        try {
            camion.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Descripción no debe ser vacio")
           padresRepository.findById(camion.padresId)
               ?: throw Exception("Id Rutas no existe")
            return docentesRepository.save(camion)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }



    fun update(docentes: Docentes): Docentes {
        try {
            docentesRepository.findById(docentes.id)
                ?: throw Exception("El id ${docentes.id} de Camion no existe")

            return docentesRepository.save(docentes)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }
    fun updateName(docentes: Docentes): Docentes {
        //Variable inmutable: VAL y la otra es var xd
        val response = docentesRepository.findById(docentes.id)
            ?: throw Exception()

        response.edad=docentes.edad
        response.nombre=docentes.nombre

        return docentesRepository.save(response)
    }
    fun delete (id:Long): Boolean{
        docentesRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?):Docentes?{
        return docentesRepository.findById(id)
    }
    fun getByTruck (nombre: String?):List <Docentes>?{
        return docentesRepository.getListTruck(nombre)
    }
    fun validateSerialNumber (serial:String?): Boolean?{
        serial.takeIf { !it?.trim().isNullOrEmpty() }
            ?: throw Exception()

        if (serial?.substring(0, 3).equals("786"))
            return true

        return false
        /*try {
                serial.takeIf { !it?.trim().isNullOrEmpty() }
                    ?: throw Exception()
                if (serial?.substring(0, 3).equals("786"))
                    return true
                return false
            }
            catch (e: Exception) {
                throw Exception()
            }*/
    }

    fun multi (coeficiente: Long, digito: Int):Long{
        val response = coeficiente * digito
        if (response >= 10)
            return response -9
        return response
    }
    fun sumaValores (nui: String) : Long{
        var sum: Long=0
        for ( i in 0..8) {
            val coeficiente = if(i%2 ==0) 2 else 1
            sum += multi(2,Integer.parseInt(nui[i].toString()) )

        }
        return sum
    }
    fun findDecenaSuperior (sum: Long): Long { // buscar la decena superior

        return 1
    }


}