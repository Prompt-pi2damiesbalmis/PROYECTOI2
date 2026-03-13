package com.pmdm.proyectobase2425.di

import android.content.Context
import androidx.room.Room
import com.google.firebase.appdistribution.gradle.ApiService
import com.pmdm.proyectobase2425.data.room.ComunidadDao
import com.pmdm.proyectobase2425.data.room.EventoDao
import com.pmdm.proyectobase2425.data.room.UsuarioComunidadDao
import com.pmdm.proyectobase2425.data.room.UsuarioDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://10.0.2.2:9000/api"


    // ── Room ─────────────────────────────────────────────────

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "ecoquest.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideComunidadDao(db: AppDatabase): ComunidadDao = db.comunidadDao()

    @Provides
    fun provideEventoDao(db: AppDatabase): EventoDao = db.eventoDao()

    @Provides
    fun provideUsuarioDao(db: AppDatabase): UsuarioDao = db.usuarioDao()

    @Provides
    fun provideUsuarioComunidadDao(db: AppDatabase): UsuarioComunidadDao = db.usuarioComunidadDao()

    // ── Retrofit ─────────────────────────────────────────────

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

        val timeout = 10L
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}