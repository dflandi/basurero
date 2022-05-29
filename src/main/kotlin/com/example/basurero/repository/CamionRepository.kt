package com.example.basurero.repository



import com.example.basurero.model.Camion
import com.example.basurero.model.Rutas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CamionRepository: JpaRepository<Camion, Long>{
fun findById(id:Long?):Camion?

    @Query(nativeQuery=true)

    fun getListTruck( @Param("horas") horas:String?) : List <Camion>?
}






