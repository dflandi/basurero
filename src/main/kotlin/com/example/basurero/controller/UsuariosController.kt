package com.example.basurero.controller;


import com.example.basurero.model.Usuarios
import com.example.basurero.service.UsuariosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Usuarios")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH])

class UsuariosController {

    @Autowired
    lateinit var usuariosService: UsuariosService

    @GetMapping
    fun list ():List <Usuarios>{
        return usuariosService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Usuarios?{
        return usuariosService.getById(id)
    }
    @GetMapping("/nombre/{nombre}")
    fun listByName (@PathVariable("nombre")nombre:String):List<Usuarios>?{
        return  usuariosService.getByName(nombre)
    }

    @PostMapping
    fun save(@RequestBody usuarios: Usuarios):Usuarios{
        return usuariosService.save(usuarios)
    }
    @PutMapping
    fun update (@RequestBody usuarios: Usuarios):Usuarios{
        return usuariosService.update(usuarios)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return usuariosService.delete(id)
    }
    @PatchMapping
    fun updateName (@RequestBody usuarios: Usuarios):Usuarios{
        return usuariosService.updateName(usuarios)
    }
}

