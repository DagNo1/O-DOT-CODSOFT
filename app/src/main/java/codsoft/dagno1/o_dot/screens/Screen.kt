package codsoft.dagno1.o_dot.screens

sealed class Screen(val route: String){
    object SplashScreen: Screen("splash_screen")
    object Onboarding : Screen("onboarding_screen")
    object Signup : Screen("signup_screen")
    object MainLayout : Screen("main_screen")
    object AddEdit : Screen("add_edit_screen")
}
