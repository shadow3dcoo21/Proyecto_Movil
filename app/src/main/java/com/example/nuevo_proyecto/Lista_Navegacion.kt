package com.example.nuevo_proyecto

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<EjemploViewModel>()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        setContent {
            Principal(viewModel = viewModel)
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Principal(viewModel: EjemploViewModel){
    val navegacion= rememberNavController()
    NavHost(navController = navegacion, startDestination ="Login_oficial" ){

        composable("pantalla1"){ Inicioo_(navegacion,viewModel)}
        composable("pantalla2"){ Dispositivos_conectados(navegacion , viewModel) }
        composable("pantalla3"){ Programacion_Horaria(navegacion) }
        composable("pantalla4"){ Vida_Util(navegacion) }
        composable("pantalla5"){ Configurar_Horario(navegacion) }
        composable("pantalla6"){ Modificar_Esta(navegacion) }
        composable("pantalla7"){ Consumo(navegacion) }
        composable("seguridad"){ Seguridad(navegacion) }
        composable("pantalla9") { Estado(navegacion,viewModel) }
        composable("Estado2") { Estado2(navegacion,viewModel) }
        composable("Estado3") { Estado3(navegacion,viewModel) }
        composable("alarma"){ Alarma(navegacion,viewModel) }

        composable(
            route = "verif/{dni}/{password}",
            arguments = listOf(
                navArgument("dni") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            ))
        { navBackStackEntry ->
            val dni = navBackStackEntry.arguments?.getString("dni").orEmpty()
            val password = navBackStackEntry.arguments?.getString("password").orEmpty()

            ScreenRegistrado(navController = navegacion, dni = dni, password = password)


        }

        composable("historial"){ Historial(navegacion) }
        composable("botones"){ Botones(navegacion, viewModel) }

        composable("Login_oficial") { MainScreen(navegacion) }
        composable(
            route = "verif/{dni}/{password}",
            arguments = listOf(
                navArgument("dni") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            ))
        { navBackStackEntry ->
            val dni = navBackStackEntry.arguments?.getString("dni").orEmpty()
            val password = navBackStackEntry.arguments?.getString("password").orEmpty()
            Inicioo_(navController = navegacion,viewModel)



        }
        composable("registro"){ ScreenNuevo(navController = navegacion)}

    }
}
