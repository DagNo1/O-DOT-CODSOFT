package codsoft.dagno1.o_dot.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import codsoft.dagno1.o_dot.R
import codsoft.dagno1.o_dot.components.CustomInput
import codsoft.dagno1.o_dot.ui.theme.Gray
import codsoft.dagno1.o_dot.ui.theme.BlueNcs
import codsoft.dagno1.o_dot.ui.theme.MainGradient
import codsoft.dagno1.o_dot.ui.theme.interFamily


@Composable
fun Signup(navController: NavController) {
    var username by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.1f))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(0.2f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .height(130.dp)
                    .width(135.dp)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painter = painterResource(id = R.drawable.o_dot),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(175.dp)
            )
        }
        Text(
            text = "What should I call you?",
            style = TextStyle(
                fontFamily = interFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = BlueNcs
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        CustomInput(
            value = username,
            onValueChange = { username = it},
            label = "Username",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
            )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(brush = MainGradient)
                .clickable {
                    // save user
                    navController.navigate(Screen.Onboarding.route)
                }
                .padding(vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Get Started",
                style = TextStyle(
                    fontFamily = interFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Gray
                ),
                textAlign = TextAlign.Center,
            )
        }
        Spacer(modifier = Modifier.weight(0.2f))

    }
}
