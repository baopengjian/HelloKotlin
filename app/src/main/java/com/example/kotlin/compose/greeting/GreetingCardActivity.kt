package com.example.kotlin.compose.greeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin.R

/**
 */
class GreetingCardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.White) {
                    GreetingImage("dog","Ray")
                }
        }
    }

    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.dog)

        Box {
            Image(painter = image, contentDescription = null)
        }

        Greeting(name = message)
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
            GreetingImage("dog","11")
    }

    @Composable
    fun Greeting(name: String) {
        Surface(color = Color.Magenta) {
            Text(
                text = "Hi,I am a $name!",
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}