package com.example.nuevo_proyecto

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nuevo_proyecto.ui.theme.Nuevo_ProyectoTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Principal()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Principal(){
    val navegacion= rememberNavController()
    NavHost(navController = navegacion, startDestination ="pantalla1" ){

        composable("pantalla1"){ Inicioo_(navegacion)}
        composable("pantalla2"){ Dispositivos_conectados(navegacion) }
        composable("pantalla3"){ Programacion_Horaria(navegacion) }
        composable("pantalla4"){ Vida_Util(navegacion) }
        composable("pantalla5"){ Configurar_Horario(navegacion) }
        composable("pantalla6"){ Modificar_Esta(navegacion) }
        composable("pantalla7"){ Consumo(navegacion) }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun Vista() {
    Principal()
}