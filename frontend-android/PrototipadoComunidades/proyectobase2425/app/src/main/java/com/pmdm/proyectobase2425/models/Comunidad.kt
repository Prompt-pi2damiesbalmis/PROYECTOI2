package com.pmdm.proyectobase2425.models

data class Comunidad(
    val id: Long = 0,
    val nombre: String = "",
    val descripcion: String = "",
    val imagen: String = ""
) {
    constructor() : this(
        comunidadId = 0,
        nombre = "",
        imagen = "",
        descripcion = "",
        usuarios = mutableListOf(),
        eventos = mutableListOf()
    )
}