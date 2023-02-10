package aaa.admin.flipgame3commat3.presentation.navigation

import aaa.admin.flipgame3commat3.presentation.screens.FiklikGameScreen
import aaa.admin.flipgame3commat3.presentation.screens.FiklikHomeScreen
import aaa.admin.flipgame3commat3.presentation.screens.FiklikashScreen
import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FiklikNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.FiklikashRoute.route
) {
    val gamlimact = LocalContext.current as Activity

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.FiklikashRoute.route) { backStackEntry ->
            FiklikashScreen(navController = navController)
        }
        composable(Screen.FiklikHomeRoute.route) { backStackEntry ->
            FiklikHomeScreen(navController = navController)
            BackHandler() {
                gamlimact.finish()
            }
        }
        composable(Screen.FiklikGameRoute.route) {
            FiklikGameScreen()
        }
    }
}
