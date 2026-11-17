package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

val AndroidGreen = Color(0xFF006D3B)
val CardBackground = Color(0xFFD2E8D4)
val LogoBackground = Color(0xFF073042)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = CardBackground
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CardBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        LogoNameTitle()
        Spacer(modifier = Modifier.weight(1f))
        ContactInformation(modifier = Modifier.padding(bottom = 48.dp))
    }
}

@Composable
fun LogoNameTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .background(LogoBackground)
                .padding(8.dp)
        )
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 40.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.title),
            color = AndroidGreen,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        ContactRow(
            icon = Icons.Filled.Phone,
            iconDescription = stringResource(R.string.phone_description),
            text = stringResource(R.string.phone)
        )
        ContactRow(
            icon = Icons.Filled.Share,
            iconDescription = stringResource(R.string.social_description),
            text = stringResource(R.string.social_handle)
        )
        ContactRow(
            icon = Icons.Filled.Email,
            iconDescription = stringResource(R.string.email_description),
            text = stringResource(R.string.email)
        )
    }
}

@Composable
fun ContactRow(
    icon: ImageVector,
    iconDescription: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = AndroidGreen
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}
