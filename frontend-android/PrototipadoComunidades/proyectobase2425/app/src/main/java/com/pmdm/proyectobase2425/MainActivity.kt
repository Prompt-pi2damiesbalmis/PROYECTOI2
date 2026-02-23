package com.pmdm.proyectobase2425

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pmdm.proyectobase2425.ui.theme.features.home.HomeScreen
import com.pmdm.proyectobase2425.ui.theme.ProyectoBase2425Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoBase2425Theme {
                HomeScreen{}
            }
        }
    }
}



