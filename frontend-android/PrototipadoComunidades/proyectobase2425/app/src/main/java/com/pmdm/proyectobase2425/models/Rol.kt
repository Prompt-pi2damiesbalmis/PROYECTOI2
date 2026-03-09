package com.pmdm.proyectobase2425.models

data class Rol(
    var id: Int,
    var nombreRol: String
) {
    constructor() : this(
        id = 0,
        nombreRol = ""
    )
}