package com.example.basurero.controller;


import com.example.basurero.dto.TiempoRutasDto
import com.example.basurero.model.Rutas
import com.example.basurero.service.RutasService
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
    @GetMapping("/tiempoRutas/{tiempoRutas}")
    fun listByRoutes (@PathVariable("tiempoRutas")tiempoRutas:String):List<Rutas>?{
        return  rutasService.getByRoutes(tiempoRutas)
    }

    //localhost:8081/students/changeName
    @PostMapping("/other/timeRoutes}")
    fun updateOtherTimeRoutes (@RequestBody tiempoRutasDto: TiempoRutasDto):Boolean?{
        return  rutasService.updateOtherTimeRoutes(tiempoRutasDto)
    }


    @PostMapping
    fun save( @RequestBody rutas: Rutas): Rutas {
        return rutasService.save(rutas)
    }
    @PutMapping
    fun update (@RequestBody rutas: Rutas):Rutas {
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