package com.example.kotlin.compose.birthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.R

/**
 *
 */
class HappyBirthdayActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
            ) {
                GreetingImage(
                    message = getString(R.string.happy_birthday_text), from = getString(
                        R.string.signature_text
                    )
                )

            }
        }

        //    var  extendTest = ExtendTest();
        //    extendTest.test();
    }


    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.birthday);
        Box {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                alpha = 0.5f,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            GreetingText(
                message = message, from = from, modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }


    @Composable
    fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
        // Create a column so that texts don't overlap
        Column(
            verticalArrangement = Arrangement.Center, modifier = modifier
        ) {
            Text(
                text = message, fontSize = 100.sp, lineHeight = 116.sp, textAlign = TextAlign.Center
            )
            Text(
                text = from,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }

}