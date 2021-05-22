package io.kotlin.psw.planetastarwars.planeta

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanetaRepository: JpaRepository<Planeta, Long> {

}
