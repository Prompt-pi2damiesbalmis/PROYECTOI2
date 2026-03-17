package com.pmdm.proyectobase2425.models

data class UsuarioComunidad(
    val id: Long = 0,
    val usuario: Usuario = Usuario(),
    val comunidad: Comunidad = Comunidad(),
    val rol: String = ""
)