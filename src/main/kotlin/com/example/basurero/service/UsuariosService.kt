

import com.example.basurero.repository.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuariosService {
    @Autowired
    lateinit var usuariosRepository: UsuariosRepository
        fun list() : List<Usuarios> {
        return usuariosRepository.findAll()
        }

    fun save (usuarios: Usuarios):Usuarios{
        return usuariosRepository.save(usuarios)
    }
    //update tb set  name = "juan" where  id=3
    fun update (usuarios:Usuarios):Usuarios{
        usuariosRepository.findById(usuarios.id) ?: throw Exception()
        return usuariosRepository.save(usuarios)

    }
    fun updateName(usuarios: Usuarios): Usuarios {
        //Variable inmutable: VAL y la otra es var xd
        val response = usuariosRepository.findById(usuarios.id)
            ?: throw Exception()

        response.Edad=usuarios.Edad


        return usuariosRepository.save(response)

    }
    fun delete (id:Long): Boolean{
     usuariosRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?):Usuarios?{
        return usuariosRepository.findById(id)
    }
}