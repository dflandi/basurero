

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Usuarios")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH])

class UsuariosController {

    @Autowired
    lateinit var usuariosService: UsuariosService

    @GetMapping
    fun list ():List < Usuarios>{
        return usuariosService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Usuarios?{
        return usuariosService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody usuarios: Usuarios):Usuarios{
        return usuariosService.save(usuarios)
    }
    @PutMapping
    fun update (@RequestBody usuarios: Usuarios):Usuarios{
        return usuariosService.update(usuarios)
    }
    @PatchMapping
    fun updateName (@RequestBody usuarios: Usuarios):Usuarios{
        return usuariosService.updateName(usuarios)
    }
}

