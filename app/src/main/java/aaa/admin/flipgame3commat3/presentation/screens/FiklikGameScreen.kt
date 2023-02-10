package aaa.admin.flipgame3commat3.presentation.screens

import aaa.admin.flipgame3commat3.data.utils.Fikliku
import aaa.admin.flipgame3commat3.presentation.ui.theme.Fiklikdc
import aaa.admin.flipgame3commat3.presentation.ui.theme.Fiklikgc
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FiklikGameScreen(
    modifier: Modifier = Modifier
) {
    var state by remember { mutableStateOf(CardFace.Front) }
    var score by remember { mutableStateOf(0) }

    Surface(
        modifier.fillMaxSize()
    ) {
        Fikliku.Fiklikimg()
        Column(
            modifier = modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Call out the card",

                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                text = "Your click counter: $score",
                fontSize = 24.sp,
                color = Color.White
            )

            FlipCard(
                modifier = modifier.size(200.dp, 300.dp),
                cardFace = state,
                onClick = {
                    score++
                    state = it.next
                },
                axis = RotationAxis.AxisY,
                back = {
                    Text(
                        text = "Click",
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        color = Fiklikdc
                    )
                },
                front = {
                    Text(
                        text = "Click",
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        color = Fiklikgc
                    )
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFiklikame() {
    FiklikGameScreen()
}

enum class CardFace(val angle: Float) {

    Front(-1800f) {
        override val next: CardFace
            get() = Back
    },
    Back(1620f) {
        override val next: CardFace
            get() = Front
    };

    abstract val next: CardFace
}

enum class RotationAxis {
    AxisX,
    AxisY,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlipCard(
    cardFace: CardFace,
    onClick: (CardFace) -> Unit,
    modifier: Modifier = Modifier,
    axis: RotationAxis = RotationAxis.AxisX,
    back: @Composable () -> Unit = {},
    front: @Composable () -> Unit = {},
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(
            durationMillis = 5000,
            easing = FastOutSlowInEasing,
        )
    )

    Card(
        onClick = { onClick(cardFace) },
        modifier = modifier
            .graphicsLayer {
                if (axis == RotationAxis.AxisX) {
                    rotationX = rotation.value
                } else {
                    rotationY = rotation.value
                }
                cameraDistance = 4f * density
            },
    ) {
        if (rotation.value <= 0f) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Fiklikdc),
                contentAlignment = Alignment.Center,
            ) {
                front()
            }
        } else if (rotation.value >= 0f) {
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        if (axis == RotationAxis.AxisY) {
                            rotationY = 180f
                        } else {
                            rotationX = 180f
                        }
                    }
                    .background(Fiklikgc),
                contentAlignment = Alignment.Center
            ) {
                back()
            }
        }
    }
}

