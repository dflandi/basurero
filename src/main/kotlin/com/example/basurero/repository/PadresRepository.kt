package com.example.basurero.repository

import com.example.basurero.model.Padres


import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface PadresRepository: JpaRepository<Padres, Long>{
    fun findById(id:Long?): Padres?

    @Query(nativeQuery=true)
    fun getListRoutes( @Param("telefono") telefono:String?) : List <Padres>?
    @Modifying
    @Transactional
    @Query(nativeQuery=true)
    fun setOtherTimeRoutes (@Param("telefono")  tiempoRutas: String?, @Param("nuevoTelefono") nuevoTelefono:String?):List <Padres>?





}






