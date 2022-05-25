package com.example.basurero.model;
import javax.persistence.*

@Entity
@Table(name="Rutas")
class Rutas{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    var tiempoRutas: Long? = null
    var nombreRutas: String? = null
    @Column(name = "Usuarios_id")
    var usuariosId:Long?=null

}