package com.example.basurero.repository
import com.example.basurero.dto.User
import com.example.basurero.model.Usuarios


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UsuariosRepository: JpaRepository<Usuarios, Long>{
    fun findById(id:Long?): Usuarios?

    @Query(nativeQuery=true)
    fun getListName( @Param("nombre") nombre:String?) : List <Usuarios>?

    @Query(nativeQuery=true)
    fun newNameUser( @Param("userName") userName: User) : List <Usuarios>?
}






