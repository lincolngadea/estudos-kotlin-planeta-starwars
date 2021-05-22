package io.kotlin.psw.planetastarwars.planeta

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank


@Entity
class Planeta(
    @NotBlank
    val name: String,
    @NotBlank
    val weather: String,
    @NotBlank
    val terrain: String
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
