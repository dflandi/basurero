package com.example.basurero.repository



import com.example.basurero.model.Camion
import org.springframework.data.jpa.repository.JpaRepository

interface CamionRepository: JpaRepository<Camion, Long>{
fun findById(id:Long?):Camion?

}






