package com.example.basurero.controller;


import com.example.basurero.dto.TelefonoDto
import com.example.basurero.model.Padres
import com.example.basurero.service.PadresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Padres")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH])
class PadresController {

    @Autowired
    lateinit var padresService: PadresService

    @GetMapping
    fun list ():List <Padres>{
        return padresService.list()
    }
    @GetMapping("/telefono/{telefono}")
    fun listByRoutes (@PathVariable("telefono")telefono:String):List<Padres>?{
        return  padresService.getByRoutes(telefono) //
    }

    //localhost:8081/students/changeName



    @PostMapping
    fun save( @RequestBody padres: Padres): Padres {
        return padresService.save(padres)
    }
    @PutMapping
    fun update (@RequestBody padres: Padres):Padres {
        return padresService.update(padres)
    }
    @PatchMapping
    fun updateName (@RequestBody padres: Padres):Padres{
        return padresService.updateName(padres)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return padresService.delete(id)
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Padres?{
        return padresService.getById(id)
    }
}