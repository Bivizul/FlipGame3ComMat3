package aaa.admin.flipgame3commat3.presentation.screens

import aaa.admin.flipgame3commat3.R
import aaa.admin.flipgame3commat3.presentation.navigation.Screen
import aaa.admin.flipgame3commat3.presentation.ui.theme.Fikliko
import aaa.admin.flipgame3commat3.presentation.ui.theme.Typography
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun FiklikHomeScreen(
    modifier: Modifier = Modifier, navController: NavHostController
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier) {
            Text(
                color = Color.White,
                text = stringResource(id = R.string.app_name),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                style = Typography.titleMedium
            )
        }

        Box(modifier = modifier) {
            Button(
                modifier = modifier,
                onClick = { navController.navigate(Screen.FiklikGameRoute.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Fikliko, contentColor = Color.White
                )
            ) {
                Text(
                    modifier = modifier.padding(8.dp),
                    text = "Start game",
                    fontSize = 28.sp
                )
            }
        }
    }

}
