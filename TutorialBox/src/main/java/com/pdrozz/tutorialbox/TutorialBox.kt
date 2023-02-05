package com.pdrozz.tutorialbox

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.pdrozz.tutorialbox.state.TutorialBoxState
import com.pdrozz.tutorialbox.state.rememberTutorialBoxState
import com.pdrozz.tutorialbox.tutorialscope.TutorialBoxScope

/**
 * TutorialBox will highlight your composable layout, you just need to wrap them.
 * Then use [Modifier.markForTutorial] in your layout
 *
 */
@Composable
fun TutorialBox(
    showTutorial: Boolean,
    onTutorialCompleted: () -> Unit,
    modifier: Modifier = Modifier,
    state: TutorialBoxState = rememberTutorialBoxState(),
    content: @Composable TutorialBoxScope.() -> Unit,
) {
    val scope = remember(state, showTutorial) {
        state.currentTargetIndex = state.initialIndex
        TutorialBoxScope(state)
    }

    BoxWithConstraints(modifier) {
        val constraints = this.constraints
        scope.content()
        if (showTutorial) {
            scope.TutorialCompose(
                state = state,
                constraints = constraints,
                onTutorialCompleted = onTutorialCompleted,
                onTutorialIndexChanged = {}
            )
        }
    }
}

/**
 * TutorialBox will highlight your composable layout, you just need to wrap them.
 * Then use [Modifier.markForTutorial] in your layout
 *
 * Using [tutorialTarget] you can provides a custom tutorial for any item flaged with
 * [Modifier.markForTutorial]
 */
@Composable
fun TutorialBox(
    showTutorial: Boolean,
    onTutorialCompleted: () -> Unit,
    modifier: Modifier = Modifier,
    state: TutorialBoxState = rememberTutorialBoxState(),
    tutorialTarget: (@Composable (index: Int) -> Unit) = {},
    content: @Composable TutorialBoxScope.() -> Unit,
) {
    val scope = remember(state, showTutorial) {
        state.currentTargetIndex = state.initialIndex
        TutorialBoxScope(state)
    }

    BoxWithConstraints(modifier) {
        val constraints = this.constraints
        scope.content()
        if (showTutorial) {
            scope.TutorialCompose(
                state = state,
                constraints = constraints,
                onTutorialCompleted = onTutorialCompleted,
                onTutorialIndexChanged = {},
                customTutorialTarget = tutorialTarget
            )
        }
    }
}