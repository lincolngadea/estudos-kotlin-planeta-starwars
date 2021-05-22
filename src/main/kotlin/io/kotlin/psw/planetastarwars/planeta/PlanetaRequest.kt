package io.kotlin.psw.planetastarwars.planeta

class PlanetaRequest(
    private val name: String,
    private val weather: String,
    private val terrain: String
) {
    fun toModel():Planeta = Planeta(name,weather,terrain)
}
