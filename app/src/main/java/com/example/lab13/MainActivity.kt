package com.example.lab13

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab13.ui.theme.Lab13Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab13Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var inputText = remember { mutableStateOf("") }
    var showError = remember { mutableStateOf(false) }
    var message = remember { mutableStateOf("") }
    var randomNumber = remember { mutableStateOf((1..10).random()) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Попробуйте угадать число!",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                label = { Text("Введите число") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                singleLine = true,
                isError = showError.value
            )

            Button(
                onClick = {
                    if (inputText.value.isEmpty()) {
                        showError.value = true
                        message.value = "Пожалуйста, введите число!"
                    } else {
                        val userNumber = inputText.value.toIntOrNull()
                        if (userNumber == null) {
                            showError.value = true
                            message.value = "Введите корректное число!"
                        } else if (userNumber !in 1..10) {
                            showError.value = true
                            message.value = "Число должно быть в диапазоне от 1 до 10."
                        } else {
                            showError.value = false
                            if (userNumber == randomNumber.value) {
                                message.value = "Вы угадали! Загаданное число: ${randomNumber.value}"
                            } else {
                                message.value = "Вы ввели неправильное число. Ваше число: $userNumber. Загаданное число: ${randomNumber.value}"
                            }
                            randomNumber.value = (1..10).random()
                        }
                    }
                },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text("Проверить")
            }

            if (showError.value) {
                Text(
                    text = message.value,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                Text(
                    text = message.value,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab13Theme {
        MainScreen()
    }
}


/*
package com.example.lab13

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab13.ui.theme.Lab13Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab13Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var inputText by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }
    var randomNumber by remember { mutableStateOf((1..10).random()) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Попробуйте угадать число!",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Введите число") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                singleLine = true,
                isError = showError
            )

            Button(
                onClick = {
                    if (inputText.isEmpty()) {
                        showError = true
                        message = "Пожалуйста, введите число!"
                    } else {
                        val userNumber = inputText.toIntOrNull()
                        if (userNumber == null) {
                            showError = true
                            message = "Введите корректное число!"
                        } else if (userNumber !in 1..10) {
                            showError = true
                            message = "Число должно быть в диапазоне от 1 до 10."
                        } else {
                            showError = false
                            if (userNumber == randomNumber) {
                                message = "Вы угадали! Загаданное число: $randomNumber"
                            } else {
                                message = "Вы ввели неправильное число. Ваше число: $userNumber. Загаданное число: $randomNumber"
                            }
                            randomNumber = (1..10).random()
                        }
                    }
                },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text("Проверить")
            }

            if (showError) {
                Text(
                    text = message,
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab13Theme {
        MainScreen()
    }
}
*/