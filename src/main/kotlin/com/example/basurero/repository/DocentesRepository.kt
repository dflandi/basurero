package com.example.basurero.repository



import com.example.basurero.model.Docentes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DocentesRepository: JpaRepository<Docentes, Long>{
fun findById(id:Long?):Docentes?

    @Query(nativeQuery=true)

    fun getListTruck( @Param("nombre") nombre:String?) : List <Docentes>?
}






