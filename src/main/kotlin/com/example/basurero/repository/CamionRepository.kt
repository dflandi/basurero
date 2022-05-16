package com.example.basurero.repository
import Camion



import org.springframework.data.jpa.repository.JpaRepository

interface CamionRepository: JpaRepository<Camion, Long>{
fun findById(id:Long?):Camion?

}






