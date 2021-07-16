package com.example.bookui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookui.ui.theme.BookUITheme
import com.example.bookui.ui.theme.Tapeno


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookUITheme {
                // A surface container using the 'background' color from the theme
                Scaffold {
                    Column {
                        // takes 50% each
                        // but can only be applied to a colScope
                        // so had to put it in a Column
                        Column(
                            Modifier
                                .weight(1f)
                                .background(
                                    color = Color(0XFFEBEBEB),
                                ),
                        ) {
                            CoverImage()
                        }
                        Column(
                            Modifier
                                .weight(1f)
                                .background(
                                    color = Color(0XFFEBEBEB),
                                ),
                        ) {
                            Details()
                        }
                    }
                }
            }
        }
    }
}


@Preview(name = "Cover Image")
@Composable
fun CoverImage() {

    Column(
        Modifier
            .padding(12.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ) {
        Image(
            painterResource(id = R.drawable.cover),
            contentDescription = "Cover Image",
            modifier = Modifier
                .size(256.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Harry Potter and the Prisoner of Azkaban",
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontFamily = Tapeno,
            ),
            modifier = Modifier.padding(
                top = 12.dp,
            )

        )
    }


}

@Preview(name = "Details")
@Composable
fun Details() {
    Card(
        modifier = Modifier.fillMaxSize(),
        elevation = 5.dp,
        shape = RoundedCornerShape(
            topStart = 40.dp,
            topEnd = 40.dp,
        ),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            Column {
                MoreDetails()
                Description()
            }
            PriceAndCart()
        }
    }

}

@Composable
fun MoreDetails() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(
                IntrinsicSize.Min,
            ),
    ) {
        DetailColumnBuilder(property = "Rating", value = 4.1)
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        DetailColumnBuilder(property = "Pages", value = 1284)

        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
        )
        DetailColumnBuilder(property = "Language", value = "English")

    }
}

@Composable
fun Description() {
    Text(
        text = "When the Knight Bus crashes through the darkness and screeches to a halt in front of him, it's the start of another far from ordinary year at Hogwarts for Harry Potter. Sirius Black, escaped mass-murderer and follower of Lord Voldemort, is on the run - and they say he is coming after Harry. In his first ever Divination class, Professor Trelawney sees an omen of death in Harry's tea leaves . But perhaps most terrifying of all are the Dementors patrolling the school grounds, with their soul-sucking kiss.",
        style = androidx.compose.ui.text.TextStyle(
            fontSize = 16.sp,
            color = Color(0XFF7F8C8D),
            fontFamily = Tapeno,
        ),
        maxLines = 8,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(8.dp),
    )
}


@Composable
fun PriceAndCart() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                8.dp,
            )
            .fillMaxWidth(),
    ) {
        Text(
            text = "123$",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.W800,
                fontFamily = Tapeno,

                ),
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(
                200.dp,
            )
        ) {
            Text(text = "Add To Cart")
        }
    }
}


@Composable
fun DetailColumnBuilder(property: String, value: Any) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = property,
            textAlign = TextAlign.Center,
        )
        Text(
            text = "$value",
            textAlign = TextAlign.Center,
            style = androidx.compose.ui.text.TextStyle(
                color = Color(0XFF7F8C8D)
            )
        )
    }
}