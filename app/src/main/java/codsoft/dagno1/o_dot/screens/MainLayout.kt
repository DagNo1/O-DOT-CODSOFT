package codsoft.dagno1.o_dot.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import codsoft.dagno1.o_dot.R
import codsoft.dagno1.o_dot.ui.theme.BlueNcs
import codsoft.dagno1.o_dot.ui.theme.White
import codsoft.dagno1.o_dot.ui.theme.Jasper

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainLayout(navController: NavController) {
    val screens = listOf("Home", "Add", "User")
    var selectedScreen by remember { mutableStateOf(screens.first()) }

    Scaffold(
        bottomBar = {
            BottomNavigation{
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                modifier = Modifier.size(100.dp),
                                painter = painterResource(getIconForScreen(screen = screen)),
                                contentDescription = null,
                                tint = if (screen == selectedScreen) Jasper else BlueNcs,
                            )
                        },
                        selected = screen == selectedScreen,
                        onClick = {
                            selectedScreen = screen
                            if (selectedScreen == "Add") {
                                navController.navigate(Screen.AddEdit.route + "/-1")
                            }
                        },
                        modifier = Modifier
                            .background(White)
                            .padding(8.dp)
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (selectedScreen) {
                    "Home" -> Read(navController = navController)
                    "User" -> Profile(navController = navController)
                    else -> Read(navController = navController) // Default screen
                }
            }

        }
    )
}

@Composable
fun getIconForScreen(screen: String): Int {
    return when (screen) {
        "Read" -> R.drawable.logo
        "Add" -> R.drawable.add
        "User" -> R.drawable.profile
        else -> R.drawable.logo
    }
}
