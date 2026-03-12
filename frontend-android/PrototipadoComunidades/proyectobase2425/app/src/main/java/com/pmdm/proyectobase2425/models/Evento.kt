package com.pmdm.proyectobase2425.models

import java.time.LocalDateTime

data class Evento(
    var eventoId: Long,
    var nombre: String,
    var ubicacion: String,
    var descripcion: String,
    var imagen: String,
    var fecha: LocalDateTime
) {
    constructor() : this(
        eventoId = 0,
        nombre = "",
        ubicacion = "",
        descripcion = "",
        imagen = "",
        fecha = LocalDateTime.now()
    )
}