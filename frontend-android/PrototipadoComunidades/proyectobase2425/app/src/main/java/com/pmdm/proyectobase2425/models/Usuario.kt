package com.pmdm.proyectobase2425.models

import java.time.LocalDateTime

data class Usuario(
    var usuarioId: Long,
    var contraseña: String,
    var admin: Boolean,
    var nombreUsuario: String,
    var nombre: String,
    var apellidos: String,
    var correo: String,
    var imagen: String,
    var descripcion: String,
    var edad: LocalDateTime,
    var comunidades: MutableList<Comunidad> = mutableListOf(),
    var puntos: Int,
    var puntosExperiencia: Int,
    var productos: MutableList<Producto> = mutableListOf()
) {
    constructor() : this(
        usuarioId = 0,
        contraseña = "",
        admin = false,
        nombreUsuario = "",
        nombre = "",
        apellidos = "",
        correo = "",
        imagen = "",
        descripcion = "",
        edad = LocalDateTime.now(),
        puntos = 0,
        puntosExperiencia = 0,
        comunidades = mutableListOf(),
        productos = mutableListOf()
    )
}