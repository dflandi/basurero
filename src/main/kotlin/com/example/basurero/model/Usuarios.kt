package com.example.basurero.model;
import javax.persistence.*

@Entity
@Table(name = "Usuarios")
class Usuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var edad: Long? = null
    var password: Long? = null
    var nombre: String? = null

}