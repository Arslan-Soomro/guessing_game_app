package com.example.guessinggame.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.guessinggame.composables.Layout


val getRandomNum = { (1..1000).random() }
val getDisplayText: (Int, Int) -> String = { userNum, randNum ->
    when {
        userNum > randNum -> "You guessed a greater number, try again"
        userNum < randNum -> "You guessed a smaller number, try again"
        else -> "You guessed the right number this time, lets guess another number"
    }
}

@Composable
fun RenderGameScreen() {
    var randomNum = remember {
        mutableStateOf<Int>(getRandomNum())
    }

    var userNum = remember {
        mutableStateOf<Int>(0)
    }

    Layout {
        Text(text = "Guess a number between 1 and 1000")
        TextField(
            value = if(userNum.value == 0) "" else userNum.value.toString() ,
            onValueChange = { text -> userNum.value = text.toInt() },
            modifier = Modifier.padding(0.dp, 16.dp)
        )
        if (userNum.value > 0) Text(text = getDisplayText(userNum.value, randomNum.value))
        Button(onClick = {
            if(randomNum == userNum) randomNum.value = getRandomNum();
        }) {
            Text(text = "Guess")
        }
    }
}