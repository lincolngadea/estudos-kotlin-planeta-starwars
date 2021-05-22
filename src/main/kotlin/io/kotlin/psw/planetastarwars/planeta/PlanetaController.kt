package io.kotlin.psw.planetastarwars.planeta

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
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
}