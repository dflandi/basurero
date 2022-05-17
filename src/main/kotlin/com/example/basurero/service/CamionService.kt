
import com.example.basurero.repository.CamionRepository
import com.example.basurero.repository.RutasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class CamionService {
    @Autowired
    lateinit var camionRepository: CamionRepository
    @Autowired
    lateinit var rutasRepository: RutasRepository


    fun list() : List<Camion> {
        return camionRepository.findAll()
        }

    fun save(camion: Camion):Camion{
        try {
            camion.Dias?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Descripción no debe ser vacio")
           rutasRepository.findById(camion.RutasId)
               ?: throw Exception("Id Rutas no existe")
            return camionRepository.save(camion)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }


    fun update(camion: Camion): Camion {
        try {
            camionRepository.findById(camion.id)
                ?: throw Exception("El id ${camion.id} de Camion no existe")

            return camionRepository.save(camion)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }
    fun updateName(camion: Camion): Camion {
        //Variable inmutable: VAL y la otra es var xd
        val response = camionRepository.findById(camion.id)
            ?: throw Exception()

        response.Dias=camion.Dias
        response.Horas=camion.Horas

        return camionRepository.save(response)
    }
    fun delete (id:Long): Boolean{
        camionRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?):Camion?{
        return camionRepository.findById(id)
    }

}