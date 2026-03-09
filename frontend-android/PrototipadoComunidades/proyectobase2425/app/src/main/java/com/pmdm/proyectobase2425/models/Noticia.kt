package com.pmdm.proyectobase2425.models

data class Noticia(
    var noticiaId: Int,
    var autor: String,
    var descripcion: String,
    var imagen: String,
    var nombre: String
) {
    constructor() : this(
        noticiaId = 0,
        autor = "",
        descripcion = "",
        imagen = "",
        nombre = ""
    )
}