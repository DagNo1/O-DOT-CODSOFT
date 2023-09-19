package codsoft.dagno1.o_dot.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

val Coral = Color(0xFFEF8354)
val White = Color(0xFFFFFFFF)
val Gray = Color(0xFF9E9E9E)
val AliceBlue = Color(0xFFE9F0FF)
val Jasper = Color(0xFFDB5A43)
val BlueNcs = Color(0xFF575757)
val BlueNcs1 = Color(0xD6000000)
val MainGradient = Brush.verticalGradient(
    colors = listOf(Coral, Color(0xFFE06547), Jasper),
    startY = 0f,
    endY = 100f,
    tileMode = TileMode.Clamp
)
val TransparentGradient = Brush.horizontalGradient(
    colors = listOf(Color.Transparent, Color.Transparent),
    startX = 0f,
    endX = 0f
)
