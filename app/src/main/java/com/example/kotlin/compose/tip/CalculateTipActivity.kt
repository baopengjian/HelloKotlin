@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kotlin.compose.tip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlin.R
import com.example.kotlin.ui.theme.DiceRollerTheme
import java.text.NumberFormat

/**
 * 计算自定义小费
 * https://developer.android.google.cn/codelabs/basic-android-kotlin-compose-calculate-tip?hl=zh-cn&continue=https%3A%2F%2Fdeveloper.android.google.cn%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%3Fhl%3Dzh-cn%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-calculate-tip
 */
class CalculateTipActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }

    @Composable
    fun TipTimeLayout() {
        var amountInput by remember { mutableStateOf("") }
        var tipInput by remember { mutableStateOf("") }
        var roundUp by remember { mutableStateOf(false) }

        val amount = amountInput.toDoubleOrNull() ?: 0.0
        val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
        val tip = calculateTip(amount, tipPercent,roundUp)


        Column(
            modifier = Modifier
                .padding(40.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.calculate_tip),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .align(alignment = Alignment.Start)
            )
            EditNumberField(
                R.string.bill_amount,
                R.drawable.money,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                value = amountInput,
                onValueChanged = { amountInput = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )

            EditNumberField(
                labelId = R.string.how_was_the_service,
                R.drawable.percent,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                value = tipInput,
                onValueChanged = { tipInput = it },
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .fillMaxWidth()
            )

            RoundTheTipRow(roundUp = roundUp, onRoundUpChanged = {roundUp = it}, modifier = Modifier.padding(bottom = 32.dp))

            Text(
                text = stringResource(R.string.tip_amount, tip),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(150.dp))
        }
    }

    @Composable
    fun RoundTheTipRow(roundUp:Boolean,onRoundUpChanged:(Boolean)->Unit, modifier: Modifier = Modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = stringResource(R.string.round_up_tip))
            Switch(
                checked = roundUp,
                onCheckedChange = onRoundUpChanged,
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
            )
        }
    }

    @Composable
    fun EditNumberField(
        @StringRes labelId: Int,
        @DrawableRes leadingIcon: Int,
        keyboardOptions: KeyboardOptions,
        value: String,
        onValueChanged: (String) -> Unit,
        modifier: Modifier,
    ) {
        TextField(
            value = value,
            leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
            singleLine = true,
            modifier = modifier,
            onValueChange = onValueChanged,
            label = { Text(stringResource(labelId)) },
            keyboardOptions = keyboardOptions
        )
    }

    /**
     * Calculates the tip based on the user input and format the tip amount
     * according to the local currency.
     * Example would be "$10.00".
     */
    private fun calculateTip(amount: Double, tipPercent: Double = 15.0,roundUp: Boolean): String {
        var tip = tipPercent / 100 * amount
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        return NumberFormat.getCurrencyInstance().format(tip)
    }

    @Preview(showBackground = true)
    @Composable
    fun TipTimeLayoutPreview() {
        DiceRollerTheme {
            TipTimeLayout()
        }
    }


}

