package io.kotlin.psw.planetastarwars.planeta

import io.kotlin.psw.planetastarwars.compartilhado.JsonRespostaCustom
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("/planeta")
class PlanetaController(val repository: PlanetaRepository) {

    @PostMapping
    fun create(@RequestBody @Valid request: PlanetaRequest):ResponseEntity<Any> {

        val planeta = request.toModel();
        val novoPlaneta = repository.save(planeta)
        return ResponseEntity(novoPlaneta,HttpStatus.CREATED)

    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = ResponseEntity(repository.getById(id), HttpStatus.OK)

    @GetMapping
    fun getAll() = ResponseEntity(repository.findAll(),HttpStatus.OK)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<JsonRespostaCustom>{
        repository.deleteById(id)
        return ResponseEntity(JsonRespostaCustom("DELETED OK", Date()), HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id:Long, @RequestBody request: PlanetaRequest):ResponseEntity<JsonRespostaCustom>{
        val planetaAtualizado = request.toModel()
        repository.update(
            planetaAtualizado.name,
            planetaAtualizado.weather,
            planetaAtualizado.terrain,
            id
        )

        return ResponseEntity(JsonRespostaCustom("UPDATED OK",Date()),HttpStatus.CREATED)
    }


}