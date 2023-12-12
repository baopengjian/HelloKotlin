@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.compose.birthday.HappyBirthdayActivity
import com.example.kotlin.compose.greeting.GreetingCardActivity
import com.example.kotlin.compose.roll.DiceRollerActivity
import com.example.kotlin.compose.tip.CalculateTipActivity
import com.example.kotlin.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    List()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun List() {
        DiceWithButtonAndImage(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }


    @Composable
    fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {


        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

            Button(
                onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            HappyBirthdayActivity::class.java
                        )
                    )
                },
            ) {
                Text(text = "GreetingCard", fontSize = 24.sp)
            }


            Button(
                onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            GreetingCardActivity::class.java
                        )
                    )
                },
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text(text = stringResource(R.string.happy_birthday_text), fontSize = 24.sp)
            }

            Button(
                onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            DiceRollerActivity::class.java
                        )
                    )
                },
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text(text = stringResource(R.string.dice_roller), fontSize = 24.sp)
            }

            Button(
                onClick = {
                    startActivity(
                        Intent(
                            this@MainActivity,
                            CalculateTipActivity::class.java
                        )
                    )
                },
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.calculate_tip), fontSize = 24.sp

                )
            }
        }
    }


}

