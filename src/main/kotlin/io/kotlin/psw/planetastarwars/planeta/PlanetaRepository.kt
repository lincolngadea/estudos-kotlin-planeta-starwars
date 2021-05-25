package io.kotlin.psw.planetastarwars.planeta

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface PlanetaRepository: JpaRepository<Planeta, Long> {
    @Query("UPDATE Planeta p set p.name = :name, p.weather = :weather, p.terrain = :terrain WHERE p.id = :id")
    @Transactional
    @Modifying
    fun update(
        @Param("name") name: String,
        @Param("weather") weather: String,
        @Param("terrain") terrain: String,
        @Param("id") id: Long
    )
}
