package com.realtomjoney.pyxlmoose.activities.canvas

import com.realtomjoney.pyxlmoose.algorithms.AlgorithmInfoParameter
import com.realtomjoney.pyxlmoose.algorithms.LineAlgorithm
import com.realtomjoney.pyxlmoose.models.Coordinates

fun verticalMirrorToolOnPixelTapped(coordinatesTapped: Coordinates) {
    if ( outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevX != null &&  outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevY != null) {
        val lineAlgorithmInstance = LineAlgorithm(AlgorithmInfoParameter.pass(
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap,
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!,
            getSelectedColor()
        ))

        lineAlgorithmInstance.compute(Coordinates( outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevX!!,  outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevY!!), coordinatesTapped)
        lineAlgorithmInstance.compute(Coordinates(( outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap.width -  outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevX!!) - 1,  outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevY!!), Coordinates(( outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap.width - coordinatesTapped.x) - 1, coordinatesTapped.y))
    }

    outerCanvasInstance.canvasFragment.myCanvasViewInstance.overrideSetPixel(coordinatesTapped.x, coordinatesTapped.y, getSelectedColor())
    outerCanvasInstance.canvasFragment.myCanvasViewInstance.overrideSetPixel(( outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap.width - coordinatesTapped.x) - 1, coordinatesTapped.y, getSelectedColor())

    outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevX = coordinatesTapped.x
    outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevY = coordinatesTapped.y
}