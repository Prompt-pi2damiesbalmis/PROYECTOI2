package com.pmdm.proyectobase2425.models

data class Producto(
    var productoId: Long,
    var nombre: String,
    var descripcion: String,
    var puntos: Int
) {
    constructor() : this(
        productoId = 0,
        nombre = "",
        descripcion = "",
        puntos = 0
    )
}