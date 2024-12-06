package br.com.rubensrodrigues.f1companion.utils


import android.annotation.SuppressLint
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

enum class BorderType {
    Start, End, TopStart, TopEnd, BottomStart, BottomEnd, Bottom, Top
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.drawSegmentedBorder(
    strokeWidth: Dp,
    color: Color,
    borderTypes: Set<BorderType>,
    cornerPercent: Int = 0,
) = composed(
    factory = {
        val density = LocalDensity.current
        val strokeWidthPx = density.run { strokeWidth.toPx() }

        Modifier.drawBehind {
            val width = size.width
            val height = size.height
            val cornerRadius = height * cornerPercent / 100

            borderTypes.forEach { border ->
                when (border) {
                    BorderType.Start -> startVerticalLine(
                        color = color,
                        cornerRadius = cornerRadius,
                        height = height,
                        strokeWidthPx = strokeWidthPx,
                        borderTypes = borderTypes,
                    )

                    BorderType.End -> endVerticalLine(
                        width = width,
                        color = color,
                        cornerRadius = cornerRadius,
                        height = height,
                        strokeWidthPx = strokeWidthPx,
                        borderTypes = borderTypes,
                    )

                    BorderType.TopStart -> topStartCurve(
                        color = color,
                        cornerRadius = cornerRadius,
                        strokeWidthPx = strokeWidthPx
                    )

                    BorderType.TopEnd -> topEndCurve(
                        color = color,
                        width = width,
                        cornerRadius = cornerRadius,
                        strokeWidthPx = strokeWidthPx
                    )

                    BorderType.BottomStart -> bottomStartCurve(
                        color = color,
                        height = height,
                        cornerRadius = cornerRadius,
                        strokeWidthPx = strokeWidthPx
                    )

                    BorderType.BottomEnd -> bottomEndCurve(
                        color = color,
                        width = width,
                        cornerRadius = cornerRadius,
                        height = height,
                        strokeWidthPx = strokeWidthPx
                    )

                    BorderType.Bottom -> bottomLine(
                        color = color,
                        cornerRadius = 0f,
                        height = height,
                        width = width,
                        strokeWidthPx = strokeWidthPx,
                        borderTypes = borderTypes,
                    )

                    BorderType.Top -> topLine(
                        color = color,
                        width = width,
                        cornerRadius = cornerRadius,
                        strokeWidthPx = strokeWidthPx,
                        borderTypes = borderTypes,
                    )
                }
            }
        }
    }
)

private fun DrawScope.bottomEndCurve(
    color: Color,
    width: Float,
    cornerRadius: Float,
    height: Float,
    strokeWidthPx: Float
) {
    drawArc(
        color = color,
        startAngle = 0f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset(
            x = width - 2 * cornerRadius,
            y = height - 2 * cornerRadius
        ),
        size = Size(
            cornerRadius * 2,
            cornerRadius * 2
        ),
        style = Stroke(width = strokeWidthPx)
    )
}

private fun DrawScope.endVerticalLine(
    width: Float,
    color: Color,
    cornerRadius: Float,
    height: Float,
    strokeWidthPx: Float,
    borderTypes: Set<BorderType>
) {
    drawLine(
        color = color,
        start = Offset(
            x = width,
            y = if (borderTypes.contains(BorderType.TopEnd)) cornerRadius else 0f
        ),
        end = Offset(
            x = width,
            y = height - (if (borderTypes.contains(BorderType.BottomEnd)) cornerRadius else 0f)
        ),
        strokeWidth = strokeWidthPx
    )
}

private fun DrawScope.startVerticalLine(
    color: Color,
    cornerRadius: Float,
    height: Float,
    strokeWidthPx: Float,
    borderTypes: Set<BorderType>
) {
    drawLine(
        color = color,
        start = Offset(
            x = 0f,
            y = if (borderTypes.contains(BorderType.TopStart)) cornerRadius else 0f
        ),
        end = Offset(
            x = 0f,
            y = height - (if (borderTypes.contains(BorderType.BottomStart)) cornerRadius else 0f)
        ),
        strokeWidth = strokeWidthPx
    )
}

private fun DrawScope.topEndCurve(
    color: Color,
    width: Float,
    cornerRadius: Float,
    strokeWidthPx: Float
) {
    drawArc(
        color = color,
        startAngle = 270f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset(
            x = width - cornerRadius * 2,
            y = 0f
        ),
        size = Size(
            cornerRadius * 2,
            cornerRadius * 2
        ),
        style = Stroke(width = strokeWidthPx)
    )
}

private fun DrawScope.bottomLine(
    color: Color,
    cornerRadius: Float,
    height: Float,
    width: Float,
    strokeWidthPx: Float,
    borderTypes: Set<BorderType>
) {
    drawLine(
        color = color,
        start = Offset(
            x = if (borderTypes.contains(BorderType.BottomStart)) cornerRadius else 0f,
            y = height
        ),
        end = Offset(
            x = width - (if (borderTypes.contains(BorderType.BottomEnd)) cornerRadius else 0f),
            y = height
        ),
        strokeWidth = strokeWidthPx
    )
}

private fun DrawScope.bottomStartCurve(
    color: Color,
    height: Float,
    cornerRadius: Float,
    strokeWidthPx: Float
) {
    drawArc(
        color = color,
        startAngle = 90f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset(
            x = 0f,
            y = height - 2 * cornerRadius
        ),
        size = Size(
            cornerRadius * 2,
            cornerRadius * 2
        ),
        style = Stroke(width = strokeWidthPx)
    )
}

private fun DrawScope.topStartCurve(
    color: Color,
    cornerRadius: Float,
    strokeWidthPx: Float
) {
    drawArc(
        color = color,
        startAngle = 180f,
        sweepAngle = 90f,
        useCenter = false,
        topLeft = Offset.Zero,
        size = Size(
            cornerRadius * 2,
            cornerRadius * 2
        ),
        style = Stroke(width = strokeWidthPx)
    )
}

private fun DrawScope.topLine(
    color: Color,
    width: Float,
    cornerRadius: Float,
    strokeWidthPx: Float,
    borderTypes: Set<BorderType>
) {
    drawLine(
        color = color,
        start = Offset(
            x = width - (if (borderTypes.contains(BorderType.TopEnd)) cornerRadius else 0f),
            y = 0f
        ),
        end = Offset(
            x = if (borderTypes.contains(BorderType.TopStart)) cornerRadius else 0f,
            y = 0f
        ),
        strokeWidth = strokeWidthPx
    )
}