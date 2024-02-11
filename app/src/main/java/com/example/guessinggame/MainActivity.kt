package com.example.guessinggame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.guessinggame.ui.theme.GuessingGameTheme
import com.example.guessinggame.screens.RenderGameScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessingGameTheme {
                RenderGameScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuessingGamePreview() {
    GuessingGameTheme {
        RenderGameScreen()
    }
}