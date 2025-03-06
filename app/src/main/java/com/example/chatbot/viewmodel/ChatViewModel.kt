package com.example.chatbot.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbot.model.MessageModel
import com.example.chatbot.utils.Constants
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }

    private val generativeModel by lazy {
        GenerativeModel(
            modelName = "gemini-2.0-flash",
            apiKey = Constants.apiKey
        )
    }

    fun sendMessage(question: String) {
        viewModelScope.launch {
            try {
                messageList.add(MessageModel(question, "user"))
                messageList.add(MessageModel("Typing....", "model"))

                val response = generativeModel.generateContent(question)
                messageList.removeAt(messageList.lastIndex)
                
                if (response.text != null) {
                    messageList.add(MessageModel(response.text!!, "model"))
                } else {
                    messageList.add(MessageModel("Sorry, I couldn't generate a response.", "model"))
                }
            } catch (e: Exception) {
                messageList.removeAt(messageList.lastIndex)
                messageList.add(MessageModel("Error: ${e.localizedMessage ?: "Unknown error occurred"}", "model"))
            }
        }
    }
}