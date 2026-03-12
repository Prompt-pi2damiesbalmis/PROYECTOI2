package com.pmdm.proyectobase2425.models

data class UsuarioComunidad(
    var usuarioComunidadId: Long,
    var usuarioId: Long,
    var comunidadId: Int
) {
    constructor() : this(
        usuarioComunidadId = 0,
        usuarioId = 0,
        comunidadId = 0
    )
}