package com.peerbitskuldeep.jetpackcompose.sideeffectsandeffecthandlersinjetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.peerbitskuldeep.jetpackcompose.sideeffectsandeffecthandlersinjetpackcompose.ui.theme.SideEffectsAndEffectHandlersInJetpackComposeTheme
import kotlinx.coroutines.launch

//side effects used for the network call nd request

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            MyComposable()

            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()

            Scaffold(scaffoldState = scaffoldState) {
                var counter by remember {
                    mutableStateOf(0)
                }

                if(counter % 5 ==0 && counter>0)
                {
                    //method 1
                    /*scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Rudrax")
                    }*/

                        //method 2
                        //it will disappear when coroutine scope's end
                    LaunchedEffect(key1 = scaffoldState.snackbarHostState)
                    {
                        scaffoldState.snackbarHostState.showSnackbar("Rudrax")
                    }
                }

                Button(onClick = { counter++ }) {
                    Text(text = "Click me: $counter")
                }
            }

        }
    }
}

//var i = 0
//
//@Composable
//fun MyComposable()
//{
//
//    Button(onClick = {
//        i++
//        Log.d("TAG", "MyComposable: $i")
//
//    }) {
//
//        Text(text = "Click Here")
//    }
//
//}