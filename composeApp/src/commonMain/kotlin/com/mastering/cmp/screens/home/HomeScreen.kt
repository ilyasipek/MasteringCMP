package com.mastering.cmp.screens.home

import StackedSnackbarHost
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.mastering.cmp.Greeting
import com.mastering.cmp.screens.sonnertoast.SonnerToastScreen
import masteringcmp.composeapp.generated.resources.Res
import masteringcmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import rememberStackedSnackbarHostState


class HomeScreen : Screen {

    @Composable
    override fun Content() {
        HomeScreenContent()
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier
) {
    var showContent by remember { mutableStateOf(false) }

    val stackedSnackbarHostState = rememberStackedSnackbarHostState(
        maxStack = 1,
    )

    var counter by remember { mutableStateOf(0) }

    Scaffold(
        snackbarHost = {
            StackedSnackbarHost(hostState = stackedSnackbarHostState)
        },
        bottomBar = {
            Text("This is a bottom bar")
        }
    ) {

        val navigator = LocalNavigator.currentOrThrow
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                navigator.push(SonnerToastScreen())
            }) {
                Text("Sonner Toast")
            }
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }

            Button(onClick = {
                counter++
                stackedSnackbarHostState.showInfoSnackbar("Info Snackbar")
            }) {
                Text("Show a toast")
            }

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}