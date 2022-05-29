package com.example.basurero.model;
import javax.persistence.*

@Entity
@Table(name="Camion")
class Camion{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    var horas: String? = null
    var dias: String? = null
    @Column(name = "Rutas_id")
    var rutasId:Long?=null

}