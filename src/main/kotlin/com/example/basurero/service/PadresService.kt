package com.example.basurero.service;

import com.example.basurero.dto.TelefonoDto
import com.example.basurero.model.Padres
import com.example.basurero.repository.PadresRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PadresService {
    @Autowired
    lateinit var padresRepository: PadresRepository


    fun list() : List<Padres> {
        return padresRepository.findAll()
    }
    fun save (rutas: Padres): Padres {

            try {
                rutas.nombres?.takeIf { it.trim().isNotEmpty() }

                    ?: throw Exception("Tiempo de rutas no encontrada")
                return padresRepository.save(rutas)
            }catch (ex : Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
            }

    }
    //update tb set  name = "juan" where  id=3
    fun update (padres:Padres):Padres {
        try {
            padresRepository.findById(padres.id)
                ?: throw Exception("El id ${padres.id}la tabla Student no existe")
                return padresRepository.save(padres) //
        } catch (ex: Exception) {
            throw throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }
    }

    fun updateOtherTimeRoutes (telefonoDto: TelefonoDto): Boolean?{
        padresRepository.setOtherTimeRoutes(telefonoDto.telefono, telefonoDto.nuevoTelefono)
        return true
    }

    fun updateName(padres: Padres):Padres{
        //Variable inmutable: VAL y la otra es var xd
        val response = padresRepository.findById(padres.id)
            ?: throw Exception()

        response.cedula=padres.cedula


        return padresRepository.save(response)

    }
    fun delete (id:Long): Boolean{
        padresRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?):Padres?{
        return padresRepository.findById(id)
    }
    fun getByRoutes (telefono: String?):List <Padres>?{
        return padresRepository.getListRoutes(telefono)
    }

}


