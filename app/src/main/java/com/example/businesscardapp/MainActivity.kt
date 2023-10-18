package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinesscardappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinesscardappTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }

            }
        }
    }
}

@Composable
fun BusinessCardApp (){
    Column (
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Profile(
            image = painterResource(R.drawable.profile),
            name = "Rachmat Maulana",
            title = "Learner"
        )
        Spacer(Modifier.height(80.dp))
        Contact(
            emailIcon = painterResource(R.drawable.baseline_mail_outline_24),
            sosmedIcon = painterResource(R.drawable.linkedin),
            callIcon = painterResource(R.drawable.baseline_add_ic_call_24),
            number = "+6282187004030",
            sosmed = "linkedin.com/in/rachmat-maulana",
            email = "rachmatmaulana81669@gmail.com"
        )
    }
}

@Composable
private fun Profile (image: Painter, name: String, title: String, modifier: Modifier = Modifier){
    Column (
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null,
            Modifier
                .size(150.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop

        )
        Text(
            text = name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = title,
            fontSize = 20.sp,
        )
    }

}

@Composable
private fun Contact (emailIcon: Painter, sosmedIcon: Painter, callIcon: Painter, number: String, sosmed: String, email: String,modifier: Modifier = Modifier){
    Column (Modifier){
        Row (Modifier.padding(5.dp)){
            Icon(painter = emailIcon, contentDescription = null, tint = Color.Black)
            Spacer(Modifier.width(5.dp))
            Text(text = email)
        }
        Row (Modifier.padding(5.dp)){
            Image(painter = sosmedIcon, contentDescription = null, Modifier.size(24.dp))
            Spacer(Modifier.width(5.dp))
            Text(text = sosmed)
        }
        Row (Modifier.padding(5.dp)){
            Icon(painter = callIcon, contentDescription = null, tint = Color.Black)
            Spacer(Modifier.width(5.dp))
            Text(text = number)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinesscardappTheme() {
        BusinessCardApp()
    }
}