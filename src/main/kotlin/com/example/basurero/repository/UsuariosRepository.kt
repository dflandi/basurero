package com.example.basurero.repository
import Usuarios


import org.springframework.data.jpa.repository.JpaRepository

interface UsuariosRepository: JpaRepository<Usuarios, Long>{
    fun findById(id:Long?):Usuarios?

}






