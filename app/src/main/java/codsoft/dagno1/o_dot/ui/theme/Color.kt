package codsoft.dagno1.o_dot.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode

val Coral = Color(0xFFEF8354)
val Black = Color(0xFF161414)
val AliceBlue = Color(0xFFE9F0FF)
val Jasper = Color(0xFFDB5A43)
val BlueNcs = Color(0xFF0094C6)
val BlueNcs1 = Color(0x360094C6)
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
