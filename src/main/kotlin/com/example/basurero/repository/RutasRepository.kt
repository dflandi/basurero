package com.example.basurero.repository

import com.example.basurero.model.Rutas


import org.springframework.data.jpa.repository.JpaRepository
import java.time.Period

interface RutasRepository: JpaRepository<Rutas, Long>{
    fun findById(id:Long?): Rutas?


}






