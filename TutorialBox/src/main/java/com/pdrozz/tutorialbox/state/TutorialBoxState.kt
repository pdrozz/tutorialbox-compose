package com.pdrozz.tutorialbox.state

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.LayoutCoordinates

class TutorialBoxState internal constructor(
    internal val initialIndex: Int,
) {

    internal var tutorialTargets = mutableStateMapOf<Int, TutorialBoxTarget>()

    var currentTargetIndex by mutableStateOf(initialIndex)
        internal set

    val currentTarget: TutorialBoxTarget?
        get() = tutorialTargets[currentTargetIndex]
}

data class TutorialBoxTarget(
    val index: Int,
    val coordinates: LayoutCoordinates,
    val content: @Composable BoxScope.() -> Unit
)

@Composable
fun rememberTutorialBoxState(
    initialIndex: Int = 0,
): TutorialBoxState {
    return remember {
        TutorialBoxState(
            initialIndex = initialIndex,
        )
    }
}