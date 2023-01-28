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
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pdrozz.tutorialboxcompose.ui.theme.TutorialBoxComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialBoxComposeTheme {

                Scaffold(

                ) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .padding(horizontal = 24.dp, vertical = 24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconButton(onClick = { }) {
                                Icon(
                                    modifier = Modifier.size(48.dp),
                                    imageVector = Icons.Rounded.Person,
                                    contentDescription = "profile icon"
                                )
                            }
                            Text(text = "Demo screen")
                            IconButton(onClick = { }) {
                                Icon(
                                    modifier = Modifier.size(48.dp),
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
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "Card 2")
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Button(onClick = { }) {
                            Text(text = "Action button")
                        }
                    }
                }
            }
        }
    }
}