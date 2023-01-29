package com.pdrozz.tutorialboxcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pdrozz.tutorialbox.TutorialBox
import com.pdrozz.tutorialbox.state.rememberTutorialBoxState
import com.pdrozz.tutorialboxcompose.ui.theme.TutorialBoxComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialBoxComposeTheme {

                var showTutorial by remember {
                    mutableStateOf(true)
                }

                TutorialBox(
                    state = rememberTutorialBoxState(),
                    showTutorial = showTutorial,
                    onTutorialCompleted = {
                        showTutorial = false
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 24.dp, vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(onClick = { }) {
                                Icon(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .markForTutorial(
                                            index = 0,
                                            title = "Profile icon",
                                            description = "This is profile icon description"
                                        ),
                                    imageVector = Icons.Rounded.Person,
                                    contentDescription = "profile icon"
                                )
                            }
                            Text(
                                modifier = Modifier.markForTutorial(
                                    index = 5,
                                    title = "Title in middle of screen",
                                    description = "This is description, you can write anything"
                                ),
                                text = "Demo screen"
                            )
                            IconButton(onClick = { }) {
                                Icon(
                                    modifier = Modifier
                                        .size(48.dp)
                                        .markForTutorial(
                                            index = 1,
                                            title = "Settings icon",
                                            description = "This is settings icon description, you can write anything"
                                        ),
                                    imageVector = Icons.Rounded.Settings,
                                    contentDescription = "settings icon"
                                )
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp)
                                    .background(
                                        Color.Gray.copy(
                                            alpha = 0.4f
                                        ),
                                        shape = RoundedCornerShape(8)
                                    )
                                    .markForTutorial(
                                        index = 2,
                                        title = "Card 1 title",
                                        description = "This is card 1 description, you can write anything"
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Card 1")
                            }
                            Spacer(modifier = Modifier.width(24.dp))
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .height(100.dp)
                                    .background(
                                        Color.Gray.copy(
                                            alpha = 0.4f
                                        ),
                                        shape = RoundedCornerShape(8)
                                    )
                                    .markForTutorial(
                                        index = 3,
                                        title = "Card 2 title",
                                        description = "This is card 2 description, you can write anything"
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Card 2")
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Button(
                            modifier = Modifier.markForTutorial(
                                index = 4,
                                title = "Button tutorial title",
                                description = "This is button description, you can write anything"
                            ),
                            onClick = {
                                showTutorial = true
                            }) {
                            Text(text = "Tap to see tutorial again")
                        }
                    }
                }
            }
        }
    }
}