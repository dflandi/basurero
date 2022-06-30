package com.example.basurero.model;
import javax.persistence.*

@Entity
@Table(name="Padres")
class Padres{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    var nombres: String? = null
    var cedula: String? = null
    var telefono: String? = null



}