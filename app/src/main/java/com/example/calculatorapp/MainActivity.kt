package com.example.calculatorapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayCalculator(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DisplayCalculator(modifier: Modifier = Modifier){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(all=4.dp)
            .background(MaterialTheme.colorScheme.surface)
        ){

            Column(modifier = Modifier.weight(1f)){

            }

            Column {
                Row(modifier = modifier.fillMaxWidth()) {
                    CalculatorButton(isFunction = true, text = "AC", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(isFunction = true, text = "⌫", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(isFunction = true, text = "%", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(isFunction = true, text = "÷", modifier = modifier.weight(1f),
                        onClick = {

                        })
                }
                Row(modifier = modifier.fillMaxWidth()) {
                    CalculatorButton(text = "7", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = "8", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = "9", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(isFunction = true, text = "×", modifier = modifier.weight(1f),
                        onClick = {

                        })
                }
                Row(modifier = modifier.fillMaxWidth()) {
                    CalculatorButton(text = "4", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = "5", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = "6", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(isFunction = true, text = "-", modifier = modifier.weight(1f),
                        onClick = {

                        })
                }
                Row(modifier = modifier.fillMaxWidth()) {
                    CalculatorButton(text = "1", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = "2", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = "3", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(isFunction = true, text = "+", modifier = modifier.weight(1f),
                        onClick = {

                        })
                }
                Row(modifier = modifier.fillMaxWidth()) {
                    CalculatorButton(isFunction = true, text = "( )", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = "0", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(text = ".", modifier = modifier.weight(1f),
                        onClick = {

                        })
                    CalculatorButton(isFunction = true, text = "=", modifier = modifier.weight(1f),
                        onClick = {

                        })
                }
            }
        }


}

@Composable
fun CalculatorButton(modifier: Modifier = Modifier, text: String = "",
                     isFunction: Boolean = false, onClick: (String) -> Unit = {}){
    Button(modifier = modifier
        .size(88.dp)
        .clip(CircleShape)
        .padding(all = 4.dp),
        onClick = {onClick(text)},
        colors = ButtonDefaults.buttonColors(
            containerColor = if(isFunction && text=="=") {
                Color.hsl(102F, 0.48F, 0.49F)
            }else{
                MaterialTheme.colorScheme.onSecondary
            })
    ){
        Text(text = text, style = TextStyle(
            fontSize = if(isFunction && (text=="+" || text=="-" || text=="×" || text=="÷" || text=="=")) {
                40.sp
            }else if(isFunction==false){
                32.sp
            }
            else {
                24.sp
            },
            fontWeight = if(isFunction) {
                FontWeight.ExtraBold
            }
            else {
                FontWeight.Normal
            }),
            color = if(isFunction && (text=="AC" || text=="⌫")){
                Color.Red
            }else if(isFunction && text!="="){
                Color.hsl(102F, 0.48F, 0.49F)
            }else if(isFunction && text=="="){
                Color.White
            }else{
                MaterialTheme.colorScheme.primary
            })
    }
}

@Preview (name = "Light Mode")
@Preview (
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview(showBackground = true)
@Composable
fun DisplayCalculatorPreview(){
    CalculatorAppTheme {
        Surface(){
            DisplayCalculator()
        }
    }
}