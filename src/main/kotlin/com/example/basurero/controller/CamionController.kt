

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/ Camion")

class CamionController {

    @Autowired
    lateinit var camionService: CamionService

    @GetMapping
    fun list ():List <Camion>{
        return camionService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long):Camion?{
        return camionService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody camion:Camion):Camion{
        return camionService.save(camion)
    }
    @PutMapping
    fun update (@RequestBody camion: Camion):Camion{
        return camionService.update(camion)
    }
    @PatchMapping
    fun updateName (@RequestBody camion: Camion):Camion{
        return camionService.updateName(camion)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return camionService.delete(id)
    }

}

