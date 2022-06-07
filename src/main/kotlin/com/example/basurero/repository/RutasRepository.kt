package com.example.basurero.repository

import com.example.basurero.model.Rutas


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.Period
import javax.transaction.Transactional

interface RutasRepository: JpaRepository<Rutas, Long>{
    fun findById(id:Long?): Rutas?

    @Query(nativeQuery=true)
    fun getListRoutes( @Param("tiempoRutas") tiempoRutas:String?) : List <Rutas>?
    @Modifying
    @Transactional
    @Query(nativeQuery=true)
    fun setOtherTimeRoutes (@Param("tiempoRutas")  tiempoRutas: String?, @Param("nuevoTiempo") nuevoNombre:String?):List <Rutas>?





}






