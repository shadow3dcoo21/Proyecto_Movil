package com.example.nuevo_proyecto

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun Botones(navController: NavHostController , viewModel: EjemploViewModel){
    LedControlScreen(viewModel = viewModel)
}

@Composable
fun LedControlScreen( viewModel: EjemploViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                viewModel.publishMessageE("esp/led1")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Encender LED 1")
        }
        Button(
            onClick = {
                viewModel.publishMessageA("esp/led1")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Apagar LED 1")
        }
        Button(
            onClick = {
                viewModel.publishMessageE("esp/led2")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Encender LED 2")
        }
        Button(
            onClick = {
                viewModel.publishMessageA("esp/led2")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Apagar LED 2")
        }
        Button(
            onClick = {
                viewModel.publishMessageE("esp/led3")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Encender LED 3")
        }
        Button(
            onClick = {
                viewModel.publishMessageA("esp/led3")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Apagar LED 3")
        }
        Button(
            onClick = {
                viewModel.publishMessageE("esp/alarma")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Encender alarma")
        }
        Button(
            onClick = {
                viewModel.publishMessageA("esp/alarma")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Apagar alarma")
        }
        Button(
            onClick = {
                viewModel.publishMessageTE()
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Encender todo")
        }
        Button(
            onClick = {
                viewModel.publishMessageTA()
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Apagar todo")
        }
    }
}