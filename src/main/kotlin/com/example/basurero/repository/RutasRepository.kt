package com.example.basurero.repository

import com.example.basurero.model.Rutas
import com.example.basurero.model.Usuarios


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.Period

interface RutasRepository: JpaRepository<Rutas, Long>{
    fun findById(id:Long?): Rutas?

    @Query(nativeQuery=true)
    fun getListRoutes( @Param("tiempoRutas") tiempoRutas:String?) : List <Rutas>?

}






