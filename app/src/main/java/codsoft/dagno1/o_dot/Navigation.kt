package codsoft.dagno1.o_dot

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import codsoft.dagno1.o_dot.screens.Add
import codsoft.dagno1.o_dot.screens.MainLayout
import codsoft.dagno1.o_dot.screens.Onboarding
import codsoft.dagno1.o_dot.screens.Screen
import codsoft.dagno1.o_dot.screens.Signup
import codsoft.dagno1.o_dot.screens.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Add.route) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Onboarding.route) {
            Onboarding(navController = navController)
        }
        composable(Screen.Signup.route) {
            Signup(navController = navController)
        }
        composable(Screen.MainLayout.route) {
            MainLayout(navController = navController)
        }
        composable(Screen.Add.route) {
            Add(navController = navController)
        }
    }
}