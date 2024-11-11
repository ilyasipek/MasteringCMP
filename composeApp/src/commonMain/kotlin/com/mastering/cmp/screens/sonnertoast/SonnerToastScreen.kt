package com.mastering.cmp.screens.sonnertoast

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.dokar.sonner.Toast
import com.dokar.sonner.ToastType
import com.dokar.sonner.Toaster
import com.dokar.sonner.rememberToasterState

class SonnerToastScreen : Screen {
    @Composable
    override fun Content() {
        val toaster = rememberToasterState()
        var counter by remember { mutableStateOf(0) }
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Sonner Toast")
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                navigator.pop()
                            },
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier.padding(it)
            ) {
                Button(onClick = {
                    counter++
                    toaster.show(
                        Toast("Hello world! $counter", type = ToastType.Info)
                    )
                }) {
                    Text("Info toast")
                }

                Button(onClick = {
                    counter++
                    toaster.show(
                        "Hello world! $counter",
                        type = ToastType.Error
                    )
                }) {
                    Text("Error toast")
                }
                Button(onClick = {
                    counter++
                    toaster.show(
                        "Hello world! $counter",
                        type = ToastType.Error
                    )
                }) {
                    Text("Error toast")
                }
            }
            Toaster(
                state = toaster,
                darkTheme = true,
            )
        }
    }
}