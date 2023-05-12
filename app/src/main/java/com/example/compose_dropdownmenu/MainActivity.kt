package com.example.compose_dropdownmenu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.compose_dropdownmenu.ui.theme.ComposeDropdownMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDropdownMenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current
    var is_expanded by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { is_expanded = !is_expanded }) {
            Text("Click here!")
        }
        Box(contentAlignment = Alignment.Center) {
            DropdownMenu(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center),
                expanded = is_expanded,
                onDismissRequest = { is_expanded = false },
                properties = PopupProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                ),
            ) {
                DropdownMenuItem(text = { Text("One") }, onClick = {
                    Toast.makeText(context, "one", Toast.LENGTH_SHORT).show()
                    is_expanded = false
                })

                DropdownMenuItem(text = { Text("Two") }, onClick = {
                    Toast.makeText(context, "two", Toast.LENGTH_SHORT).show()
                    is_expanded = false
                })

                DropdownMenuItem(text = { Text("Three") }, onClick = {
                    Toast.makeText(context, "three", Toast.LENGTH_SHORT).show()
                    is_expanded = false
                })
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeDropdownMenuTheme {
        Greeting()
    }
}