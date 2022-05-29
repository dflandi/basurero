package com.example.basurero.service;

import com.example.basurero.model.Usuarios
import com.example.basurero.repository.RutasRepository
import com.example.basurero.repository.UsuariosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class UsuariosService {
    @Autowired
    lateinit var usuariosRepository: UsuariosRepository

        fun list() : List<Usuarios> {
        return usuariosRepository.findAll()
        }

    fun save (usuarios: Usuarios):Usuarios{
        try {
            usuarios.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Descripción no debe ser vacio")

        return usuariosRepository.save(usuarios)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
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

        response.edad=usuarios.edad


        return usuariosRepository.save(response)

    }
    fun delete (id:Long): Boolean{
     usuariosRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?):Usuarios?{
        return usuariosRepository.findById(id)
    }
    fun getByName (nombre: String?):List <Usuarios>?{
        return usuariosRepository.getListName(nombre)
    }
}