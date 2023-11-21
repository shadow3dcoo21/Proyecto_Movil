package com.example.nuevo_proyecto

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
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
fun Seguridad(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val color_fondo_top = Color(0xFFF74357B)
    val color_fondo_footer = Color.White
    val color_mass = Color.Black


    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = color_fondo_footer,
                    titleContentColor = MaterialTheme.colorScheme.background.also { Color.Red },
                ),
                title = {
                    Text(

                        modifier = Modifier
                            .fillMaxWidth()

                        ,



                        fontFamily = FontFamily.Default,
                        fontSize = 18.sp,
                        color = Color.Black,
                        text = " Seguridad "



                    )
                },
                navigationIcon = {
                    IconButton(modifier= Modifier
                        .background(Color.Transparent)
                        .clickable { navController.navigate("pantalla1") }
                        .padding(0.dp),onClick = { navController.navigate("pantalla1") }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = " ",
                            tint = Color.Black
                        )
                    }
                },

                scrollBehavior = scrollBehavior,
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = color_fondo_footer,

                actions = {
                    Row ( modifier = Modifier
                        .background(Color.White)
                    ){
                        IconButton(modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .scale(1.3f),onClick = { navController.navigate("pantalla1") }) {
                            Icon(

                                painterResource(R.drawable.home )
                                ,
                                contentDescription = " ",
                                tint = Color.Black,

                                )

                        }
                        IconButton(modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .scale(1.3f),onClick = { /* do something */ }) {
                            Icon(

                                painterResource(R.drawable.search )
                                ,
                                contentDescription = " ",
                                tint = Color.Black,

                                )
                        }
                        IconButton(modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .scale(1.5f),onClick = { /* do something */ }) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)

                                    .size(60.dp)

                                    .clip(
                                        RoundedCornerShape(
                                            topEnd = 100.dp,
                                            topStart = 100.dp,
                                            bottomEnd = 100.dp,
                                            bottomStart = 100.dp
                                        )
                                    )
                                ,
                                painter = painterResource(R.drawable.medio),
                                contentDescription ="ss"
                            )
                        }
                        IconButton(modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .scale(1.3f),onClick = { /* do something */ }) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)

                                    .size(60.dp)

                                    .clip(
                                        RoundedCornerShape(
                                            topEnd = 100.dp,
                                            topStart = 100.dp,
                                            bottomEnd = 100.dp,
                                            bottomStart = 100.dp
                                        )
                                    )
                                ,
                                painter = painterResource(R.drawable.comment),
                                contentDescription ="ss"
                            )
                        }
                        IconButton(modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .scale(1.3f),onClick = { /* do something */ }) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)


                                    .clip(
                                        RoundedCornerShape(
                                            topEnd = 100.dp,
                                            topStart = 100.dp,
                                            bottomEnd = 100.dp,
                                            bottomStart = 100.dp
                                        )
                                    )
                                ,
                                painter = painterResource(R.drawable.bell),
                                contentDescription ="ss"
                            )
                        }
                    }





                },

                )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Text(
                modifier = Modifier
                    .background(Color.Transparent).width(315.dp).align(Alignment.CenterHorizontally)
                ,

                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black,
                text = "Lista de Artefactos".trimIndent()
            )
            Row (
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(Color.Transparent)
                ,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ){

                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)

                        .size(70.dp)

                        .clip(
                            RoundedCornerShape(
                                topEnd = 100.dp,
                                topStart = 100.dp,
                                bottomEnd = 100.dp,
                                bottomStart = 100.dp
                            )
                        )
                    ,
                    painter = painterResource(R.drawable.imagen_2),
                    contentDescription ="ss"
                )
                Column (modifier = Modifier.background(Color.Transparent).width(125.dp)){
                    Text(
                        modifier = Modifier
                            .padding(1.dp)
                        ,

                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color.Black,
                        text ="Puerta Principal".trimIndent()
                    )
                    Text(
                        modifier = Modifier
                            .padding(1.dp)
                        ,

                        textAlign = TextAlign.Center,

                        fontSize = 17.sp,
                        color = Color.Black,
                        text ="Estado:".trimIndent()
                    )
                    Text(
                        modifier = Modifier
                            .padding(1.dp)
                        ,

                        textAlign = TextAlign.Center,

                        fontSize = 17.sp,
                        color = Color.Black,
                        text ="Encendido".trimIndent()
                    )
                }


                FloatingActionButton(modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .height(48.dp)
                    .background(Color.Black ,  shape = RoundedCornerShape(7.dp))
                    .padding(horizontal = 15.dp)
                    .padding(vertical = 8.dp)
                    ,
                    onClick = { navController.navigate("alarma") },
                    containerColor = color_mass,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Text(
                        modifier = Modifier
                        ,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = Color.White,
                        text ="MODIFICAR".trimIndent()
                    )
                }



            }











        }
    }

}