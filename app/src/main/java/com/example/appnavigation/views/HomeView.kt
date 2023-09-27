@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.appnavigation.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.appnavigation.components.MainButton
import com.example.appnavigation.components.MainIconButton
import com.example.appnavigation.components.Space
import com.example.appnavigation.components.TitleBar
import com.example.appnavigation.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController){
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack){
                        navController.popBackStack()
                    }
                }
            )
        }
    ){
        ContentHomeView(navController)
    }
}

@Composable
fun ContentHomeView(navController: NavController){
    val id = 123
    var opcional by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "NAVEGAÇÃO")
        Space()
        TextField(value = opcional,
            onValueChange = {opcional = it},
            label = { Text(text = "Opcional")})
        MainButton(name = "Detail View", backColor = Color.Red, color = Color.White) {
            navController.navigate("Detail/${id}/?${opcional}")
        }
    }
}