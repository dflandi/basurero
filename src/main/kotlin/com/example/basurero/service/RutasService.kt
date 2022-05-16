
import com.example.basurero.repository.RutasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RutasService {
    @Autowired
    lateinit var rutasRepository: RutasRepository
    fun list() : List<Rutas> {
        return rutasRepository.findAll()
        }
    fun save (rutas:Rutas){
        fun save(rutas:Rutas):Rutas{
            try {
                rutasRepository.findById(rutas.TiempoRutas)
                    ?: throw Exception("Tiempo de rutas no encontrada")
                return rutasRepository.save(rutas)
            }catch (ex : Exception){
                throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
            }
        }
    }
    //update tb set  name = "juan" where  id=3
    fun update (rutas:Rutas) {
        try{
            rutasRepository.findById(rutas.id)
                ?: throw Exception("El id ${rutas.id}la tabla Student no existe")

        }

        catch (ex:Exception){
            throw throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun updateName(rutas: Rutas):Rutas{
        //Variable inmutable: VAL y la otra es var xd
        val response = rutasRepository.findById(rutas.id)
            ?: throw Exception()

        response.NombreRutas=rutas.NombreRutas


        return rutasRepository.save(response)

    }
    fun delete (id:Long): Boolean{
       rutasRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?):Rutas?{
        return rutasRepository.findById(id)
    }

}