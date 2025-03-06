package com.example.chatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.chatbot.ui.theme.ChatBotTheme
import com.example.chatbot.ui.theme.screen.ChatPage
import com.example.chatbot.ui.theme.screen.InfoScreen
import com.example.chatbot.viewmodel.ChatViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val chatViewModel = ViewModelProvider(this)[ChatViewModel::class.java]

        setContent {
            ChatBotTheme {
                var showInfo by remember { mutableStateOf(false) }

                if (showInfo) {
                    InfoScreen(onNavigateBack = { showInfo = false })
                } else {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        ChatPage(
                            modifier = Modifier.padding(innerPadding),
                            viewModel = chatViewModel,
                            onNavigateToInfo = { showInfo = true }
                        )
                    }
                }
            }
        }
    }
}

