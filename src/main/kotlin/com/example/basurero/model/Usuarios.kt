import javax.persistence.*

@Entity
@Table(name = "Usuarios")
class Usuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var Edad: Long? = null
    var Nombre: String? = null
}