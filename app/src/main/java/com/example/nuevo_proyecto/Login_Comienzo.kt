package com.example.nuevo_proyecto

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Login_Comi(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val encendido = Color(0xFFF03F3F)
    val apagado = Color(0xFF539BB2)
    val color_fondo_footer = Color.White
    val color_mass = Color.Black


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),


    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)

                .padding(innerPadding),

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

                Column (modifier= Modifier.background(Color.Transparent).fillMaxWidth()){
                    var usuario by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = usuario,
                        onValueChange = { usuario = it },
                        modifier = Modifier
                            .height(70.dp)
                            .padding(2.dp)
                            .align(Alignment.CenterHorizontally)

                        ,
                        label = { Text(fontSize = 13.sp,text = "USUARIO") }
                    )

                    var contraseña by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = contraseña,
                        onValueChange = { contraseña = it },
                        modifier = Modifier
                            .height(70.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(2.dp),
                        label = { Text(fontSize = 13.sp,text = "CONTRASEÑA") }
                    )
                }








                Spacer(modifier = Modifier.height(30.dp))
                Row (modifier = Modifier
                    .background(Color.Transparent)
                    .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(50.dp),){
                    FloatingActionButton(modifier = Modifier

                        .height(48.dp)
                        .background(color_mass, shape = RoundedCornerShape(7.dp))
                        .padding(horizontal = 15.dp)
                        .padding(vertical = 8.dp)
                        ,
                        onClick = { navController.navigate("pantalla1") },
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
                            text ="INGRESAR".trimIndent()
                        )
                    }

                }





            }











        }
    }

}