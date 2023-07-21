package com.example.sampleappwithlivedata

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleappwithlivedata.ui.theme.SampleAppWithLiveDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleAppWithLiveDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyApp(){
    val moneyCounter = remember{
        mutableStateOf(0)
    }

    Surface(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "${moneyCounter.value}",
                fontSize = 39.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            CustomButton(
                moneyCounter = moneyCounter.value
            ){
                moneyCounter.value= it + 1
            }
        }
    }
}

@Composable
fun CustomButton(
    moneyCounter : Int = 0,
    updateMoneyCounter: (Int) -> Unit
){
    Card(modifier = Modifier
        .padding(4.dp)
        .size(50.dp)
        .clickable {
//            moneyCounter.value += 1
            updateMoneyCounter(moneyCounter)
            Log.d("Counter", "Counter: $moneyCounter")
        },
        shape = CircleShape,
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tap",
                textAlign = TextAlign.Center,
                modifier = Modifier,
            )
        }
    }
}
