import javax.persistence.*

@Entity
@Table(name="Rutas")
class Rutas{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    var TiempoRutas: Long? = null
    var NombreRutas: String? = null

}