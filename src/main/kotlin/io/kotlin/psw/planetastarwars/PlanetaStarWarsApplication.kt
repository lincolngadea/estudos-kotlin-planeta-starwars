package io.kotlin.psw.planetastarwars

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlanetaStarWarsApplication

fun main(args: Array<String>) {
	runApplication<PlanetaStarWarsApplication>(*args)
}
