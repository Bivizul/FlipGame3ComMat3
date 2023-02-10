package aaa.admin.flipgame3commat3.presentation.navigation

sealed class Screen(val route: String) {
    object FiklikashRoute : Screen("fiklikash")
    object FiklikHomeRoute : Screen("fiklik_home")
    object FiklikGameRoute : Screen("fiklik_game")
}