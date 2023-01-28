package com.pdrozz.tutorialbox

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable

@Composable
fun TutorialBox(
    showTutorial: Boolean,
    onTutorialCompleted: () -> Unit,
    content: @Composable () -> Unit
) {

    BoxWithConstraints {
        content()
        if (showTutorial) {
            TutorialView()
        }
    }

}

@Composable
private fun TutorialView() {

}