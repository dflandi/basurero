

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Rutas")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH])
class RutasController {

    @Autowired
    lateinit var rutasService: RutasService

    @GetMapping
    fun list ():List <Rutas>{
        return rutasService.list()
    }
    @PostMapping
    fun save(@RequestBody rutas: Rutas) {
        return rutasService.save(rutas)
    }
    @PutMapping
    fun update (@RequestBody rutas: Rutas) {
        return rutasService.update(rutas)
    }
    @PatchMapping
    fun updateName (@RequestBody rutas: Rutas):Rutas{
        return rutasService.updateName(rutas)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return rutasService.delete(id)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Rutas?{
        return rutasService.getById(id)
    }
}

