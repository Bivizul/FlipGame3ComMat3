package aaa.admin.flipgame3commat3.presentation

import aaa.admin.flipgame3commat3.data.utils.Fikliku
import aaa.admin.flipgame3commat3.presentation.navigation.FiklikNavHost
import aaa.admin.flipgame3commat3.presentation.ui.theme.FlipGame3ComMat3Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlipGame3ComMat3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Fikliku.Fiklikimg()
                    FiklikNavHost()
                }
            }
        }
    }
}