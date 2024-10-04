package com.devdeveloper.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devdeveloper.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {

    val moneyCounter = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF03A9F4)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$${moneyCounter.value}",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(
                modifier = Modifier.height(200.dp)
            )
            CreateCircle(moneyCounter = moneyCounter.value) { newValue ->
                moneyCounter.value = newValue + 1
            }

            if (moneyCounter.value > 25) {
                Text(
                    text = "Lots of Money"
                )
            }
        }
    }
}

@Composable
fun CreateCircle(
    moneyCounter: Int = 0,
    updateMoneyCounter: (Int) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(100.dp)
            .clickable {
                // moneyCounter.value += 1
                updateMoneyCounter(moneyCounter + 1)
            },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 13.dp
        )
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tap",
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyApp()
}
