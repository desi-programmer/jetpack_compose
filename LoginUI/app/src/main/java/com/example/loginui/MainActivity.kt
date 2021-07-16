package com.example.loginui


import android.graphics.drawable.shapes.RoundRectShape
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.WindowManager
import android.widget.StackView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.loginui.ui.theme.Lato


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // may use scrollable column later
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

        setContent {

            val scaffoldState = rememberScaffoldState()
            var username by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }
            var passwordVisibility: Boolean by remember { mutableStateOf(false) }
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState,
//                topBar = {
//                    TopAppBar(
//                        title = {
//                            Text(
//                                "TopAppBar",
//                                style = TextStyle(color = Color.White, fontSize = 20.sp)
//                            )
//                        },
//                    )
//                },

                backgroundColor = Color.White,
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ) {


                        Image(
                            painter = rememberImagePainter("https://seeklogo.com/images/D/digital-ocean-logo-7B970FE624-seeklogo.com.png"),
                            contentDescription = null,
                            modifier = Modifier.size(96.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "DigitalOcean", style = TextStyle(
                                color = Color.Blue,
                                fontSize = 32.sp,
                                fontFamily = Lato,
//                                    fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.Bold,
//                                    fontStyle = FontStyle.Italic,
//                                    letterSpacing = 0.5.em,
//                                    background = Color.LightGray,
                            )
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent),
                            value = username,
//                            label = {
//                                Text(text = "Enter Your Username")
//                            },
                            placeholder = {
                                Text(text = "Enter Your Username")
                            },
                            onValueChange = {
                                username = it
                            },
                            singleLine = true,
                            textStyle = TextStyle(
//                                    color = Color.Red,
                                fontSize = 18.sp,
                                fontFamily = Lato,
//                                    fontWeight = FontWeight.W800,
//                                    fontStyle = FontStyle.Italic,
//                                    letterSpacing = 0.5.em,
//                                    background = Color.LightGray,
//                                    textDecoration = TextDecoration.Underline
                            )
                        )
                        Box(modifier = Modifier.height(12.dp))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password,
//                            visualTransformation = PasswordVisualTransformation(),
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisibility = !passwordVisibility
                                }) {
                                    if (passwordVisibility) Icon(
                                        Icons.Filled.VisibilityOff,
                                        "menu"
                                    ) else Icon(Icons.Filled.Visibility, "Off")
                                }

                            },
                            placeholder = {
                                Text(text = "Enter Your Password")
                            },

                            onValueChange = {
                                password = it
                            },
                            singleLine = true,
                            textStyle = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = Lato,
                            )
                        )

                        ClickableText(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth(),
                            text = AnnotatedString(
                                text = "Forgot Password ?",
                            ),
                            style = TextStyle(
                                textAlign = TextAlign.Right,
                            ),
                            onClick = {
                                Log.i("INFO", "Click from Clickable Text !")
                            }
                        )

                        Button(
                            onClick = {
                                Log.i("INFO", username)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            shape = RoundedCornerShape(12),

                            ) {
                            Text(
                                "Login",
                                style = TextStyle(

                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = Lato,
                                ),
                            )
                        }

                    }
                }

            }
        }
    }
}
