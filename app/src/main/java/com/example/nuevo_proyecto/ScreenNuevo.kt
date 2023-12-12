package com.example.nuevo_proyecto

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenNuevo(navController: NavController) {
    var usuario by remember { mutableStateOf("") }
    var passwordNuevo by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var mensajeRegistro by remember { mutableStateOf("") }
    var mensajeFirestore by remember { mutableStateOf("") }
    val color_mass = Color.Black
    val registerUser = {
        val auth = Firebase.auth
        val correoNuevo = "$usuario@gmail.com"

        auth.createUserWithEmailAndPassword(correoNuevo, passwordNuevo)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    mensajeRegistro = "Usuario creado exitosamente"

                    val db = FirebaseFirestore.getInstance()

                    val user = hashMapOf(
                        "usuario" to usuario,
                        "password" to passwordNuevo,
                        "nombre" to nombre
                    )

                    db.collection("usuarios").document(auth.currentUser!!.uid)
                        .set(user)
                        .addOnSuccessListener {
                            mensajeFirestore = "Datos almacenados en Firestore correctamente"
                        }
                        .addOnFailureListener { e ->
                            mensajeFirestore = "Error al almacenar en Firestore: ${e.message}"
                        }
                } else {
                    mensajeRegistro = "Fallo en el registro: ${task.exception?.message}"
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
        ,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier.height(100.dp))

        Column (
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .background(Color.Transparent)
            ,

            ){

            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)

                    .size(170.dp)


                ,
                painter = painterResource(R.drawable.domotec3),
                contentDescription ="ss"
            )

            Column (modifier= Modifier
                .background(Color.Transparent)
                .fillMaxWidth()){

                OutlinedTextField(
                    value = usuario, onValueChange = { usuario = it },
                    modifier = Modifier
                        .height(70.dp)
                        .padding(2.dp)
                        .align(Alignment.CenterHorizontally)

                    ,
                    label = { Text(fontSize = 13.sp,text = "USUARIO") }
                )


                OutlinedTextField(
                    value = passwordNuevo, onValueChange = { passwordNuevo = it },
                    modifier = Modifier
                        .height(70.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(2.dp),
                    label = { Text(fontSize = 13.sp,text = "CONTRASEÑA") }
                )

                OutlinedTextField(
                    value = nombre, onValueChange = { nombre = it },
                    modifier = Modifier
                        .height(70.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(2.dp),
                    label = { Text(fontSize = 13.sp,text = "NOMBRE COMPLETO") }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row (modifier = Modifier
                .background(Color.Transparent)
                .width(235.dp)
                .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(20.dp),){
                FloatingActionButton(modifier = Modifier

                    .height(48.dp)
                    .background(color_mass, shape = RoundedCornerShape(7.dp))
                    .padding(horizontal = 15.dp)
                    .padding(vertical = 8.dp)
                    ,
                    onClick = {
                        registerUser()
                    },
                    containerColor = color_mass,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Text(
                        modifier = Modifier.background(Color.Transparent)
                        ,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.White,
                        text ="REGISTRARSE".trimIndent()
                    )
                }

                FloatingActionButton(modifier = Modifier

                    .height(48.dp)
                    .background(color_mass, shape = RoundedCornerShape(7.dp))
                    .padding(horizontal = 15.dp)
                    .padding(vertical = 8.dp)
                    ,
                    onClick = {
                        navController.navigate("Login_oficial")
                    },
                    containerColor = color_mass,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Text(
                        modifier = Modifier.background(Color.Transparent)
                        ,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.White,
                        text ="SALIR".trimIndent()
                    )
                }



            }
            Spacer(modifier = Modifier.height(10.dp))
            Row (modifier = Modifier
                .background(Color.Transparent)
                .width(185.dp)
                .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(20.dp),){

                Text(
                    text = "$mensajeRegistro\n$mensajeFirestore",
                    modifier = Modifier.padding(vertical = 20.dp)
                        .align(Alignment.CenterVertically)

                        .background(Color.Transparent,shape = RoundedCornerShape(7.dp)),


                )
            }




        }

    }











}

