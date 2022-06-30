package com.example.basurero.controller;

import com.example.basurero.model.Docentes
import com.example.basurero.service.DocentesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Docentes")

class DocentesController {

    @Autowired
    lateinit var docentesService: DocentesService

    @GetMapping
    fun list ():List <Docentes>{
        return docentesService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Docentes?{
        return docentesService.getById(id)
    }
    @GetMapping("/nombre/{nombre}")
    fun listByTruck (@PathVariable("nombre")nombre:String):List<Docentes>?{
        return docentesService.getByTruck(nombre)
    }

    @PostMapping
    fun save(@RequestBody docentes:Docentes):Docentes{
        return docentesService.save(docentes)
    }
    @PutMapping
    fun update (@RequestBody docentes: Docentes):Docentes{
        return docentesService.update(docentes)
    }
    @PatchMapping
    fun updateName (@RequestBody docentes: Docentes):Docentes{
        return docentesService.updateName(docentes)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id")id: Long):Boolean{
        return docentesService.delete(id)
    }

}

