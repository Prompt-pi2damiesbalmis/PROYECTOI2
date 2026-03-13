package com.pmdm.proyectobase2425.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pmdm.proyectobase2425.data.room.ComunidadDao
import com.pmdm.proyectobase2425.data.services.ComunidadEntity
import com.pmdm.proyectobase2425.data.room.EventoDao
import com.pmdm.proyectobase2425.data.services.EventoEntity
import com.pmdm.proyectobase2425.data.room.UsuarioComunidadDao
import com.pmdm.proyectobase2425.data.services.UsuarioComunidadEntity
import com.pmdm.proyectobase2425.data.room.UsuarioDao
import com.pmdm.proyectobase2425.data.services.UsuarioEntity
import com.pmdm.proyectobase2425.data.services.UsuarioEventoEntity


@Database(
    entities = [
        ComunidadEntity::class,
        EventoEntity::class,
        UsuarioEntity::class,
        UsuarioComunidadEntity::class,
        UsuarioEventoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun comunidadDao(): ComunidadDao
    abstract fun eventoDao(): EventoDao
    abstract fun usuarioDao(): UsuarioDao
    abstract fun usuarioComunidadDao(): UsuarioComunidadDao
}