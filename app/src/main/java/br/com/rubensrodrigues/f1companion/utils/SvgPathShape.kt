package br.com.rubensrodrigues.f1companion.utils

import android.annotation.SuppressLint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.graphics.PathParser

class SvgPathShape(
    private val path: String,
) : Shape {
    @SuppressLint("RestrictedApi")
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val composePath = PathParser.createPathFromPathData(path).asComposePath()
        val pathSize = composePath.getBounds().size
        val matrix = android.graphics.Matrix()
        matrix.postScale(
            size.width / pathSize.width,
            size.height / pathSize.height,
        )
        composePath.asAndroidPath().transform(matrix)

        return Outline.Generic(composePath)
    }
}