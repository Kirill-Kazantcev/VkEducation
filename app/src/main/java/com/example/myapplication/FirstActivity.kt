package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    FirstScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    var textInput by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = textInput,
            onValueChange = {
                textInput = it
                showError = false
            },
            label = { Text("Введите текст или номер") },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(32.dp),
            singleLine = true,
            isError = showError,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                errorBorderColor = MaterialTheme.colorScheme.error,
                errorLabelColor = MaterialTheme.colorScheme.error,
                errorCursorColor = MaterialTheme.colorScheme.error,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (textInput.isNotBlank()) {
                        val intent = Intent(context, SecondActivity::class.java)
                        intent.putExtra("EXTRA_TEXT", textInput)
                        context.startActivity(intent)
                        showError = false
                    } else {
                        showError = true
                        Toast.makeText(
                            context,
                            "Введите текст для передачи",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text("Открыть вторую Activity")
            }

            Button(
                onClick = {
                    if (textInput.isNotBlank()) {
                        val phoneNumber = textInput
                            .replace(" ", "")
                            .replace("-", "")
                        if (phoneNumber.matches(Regex("^[+]?[0-9]{10,15}$"))) {
                            val intent = Intent(
                                Intent.ACTION_DIAL,
                                Uri.parse("tel:$phoneNumber")
                            )
                            context.startActivity(intent)
                            showError = false
                        } else {
                            showError = true
                            Toast.makeText(
                                context,
                                "Введите корректный номер телефона",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    } else {
                        showError = true
                        Toast.makeText(
                            context,
                            "Введите номер телефона",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text("Позвонить другу")
            }

            Button(
                onClick = {
                    if (textInput.isNotBlank()) {
                        val intent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, textInput)
                        }
                        context.startActivity(
                            Intent.createChooser(intent, "Поделиться через")
                        )
                        showError = false
                    } else {
                        showError = true
                        Toast.makeText(
                            context,
                            "Введите текст для отправки",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text("Поделиться текстом")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    MyApplicationTheme {
        FirstScreen()
    }
}