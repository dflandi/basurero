import javax.persistence.*

@Entity
@Table(name="Camion")
class Camion{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    var Horas: Long? = null
    var Dias: String? = null
    @Column(name = "Rutas_id")
    var RutasId:Long?=null

}