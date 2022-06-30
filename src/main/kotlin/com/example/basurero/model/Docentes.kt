package com.example.basurero.model;
import javax.persistence.*

@Entity
@Table(name="docentes")
class Docentes{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    var nombre: String? = null
    var edad: String? = null
    @Column(name = "Padres_id")
    var padresId:Long?=null

}