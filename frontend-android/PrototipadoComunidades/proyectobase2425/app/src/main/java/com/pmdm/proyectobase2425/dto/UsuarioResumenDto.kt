package com.pmdm.proyectobase2425.data.dto

import com.google.gson.annotations.SerializedName

// Resumen de usuario dentro de ComunidadDto: solo nombreUsuario y rol.
data class UsuarioResumenDto(
    @SerializedName("nombreUsuario") val nombreUsuario: String = "",
    @SerializedName("rol")           val rol: String = ""
)
