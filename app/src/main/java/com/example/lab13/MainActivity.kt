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
    var randomNumber by remember { mutableStateOf((1..10).random()) } // Инициализация случайного числа
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
                            randomNumber = (1..10).random() // Генерация нового числа для следующей игры
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
    val context = LocalContext.current  // Перемещаем сюда

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
                    } else {
                        showError = false
                        Toast.makeText(
                            context,  // Теперь используем context
                            "Вы ввели: $inputText",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text("Проверить")
            }

            if (showError) {
                Text(
                    text = "Некорректное значение!",
                    color = Color.Red,
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
/*
package com.example.lab13

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab13.ui.theme.Lab13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab13Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab13Theme {
        Greeting("Android")
    }
}

*/