package com.example.nuevo_proyecto

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ScreenRegistrado(navController: NavHostController, dni:String, password:String){
    var nombre by remember { mutableStateOf("") }
    val db = FirebaseFirestore.getInstance()
    val auth = Firebase.auth
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Su Usurio es :: $dni\n y su password es: $password",
                Modifier.padding(vertical = 8.dp)
            )

            // Mostrar el nombre desde Firestore
            LaunchedEffect(Unit) {
                val userDoc = db.collection("usuarios").document(auth.currentUser!!.uid)
                userDoc.addSnapshotListener { snapshot, _ ->
                    if (snapshot != null && snapshot.exists()) {
                        nombre = snapshot.getString("nombre") ?: ""
                    }
                }
            }

            Text(text = "Nombre: $nombre", Modifier.padding(vertical = 8.dp))

            Button(
                onClick = { navController.navigate("pantalla1") },
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Text(text = "Salir")
            }
        }
    }
}

