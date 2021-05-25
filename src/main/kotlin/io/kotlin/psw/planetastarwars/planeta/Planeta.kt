package io.kotlin.psw.planetastarwars.planeta

import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
@Table(name = "planeta")
class Planeta(
    @NotBlank
    @Column(name="name", nullable = false)
    val name: String,

    @NotBlank
    @Column(name="weather", nullable = false)
    val weather: String,

    @NotBlank
    @Column(name="terrain", nullable = false)
    val terrain: String
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
