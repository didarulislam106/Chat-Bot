# Android Chat Bot Application

A modern Android chat bot application built with Jetpack Compose that demonstrates clean architecture and material design principles.

## Features

- Real-time chat interface
- Material Design 3 implementation
- ℹ About/Info screen
- Responsive UI
- State management using ViewModel
- Modern Jetpack Compose UI

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **State Management**: ViewModel + State
- **Design System**: Material Design 3
- **API Integration**: Google Gemini AI API

## API Integration

### Google Gemini AI
This application uses Google's Gemini AI API for generating responses. To use the app:

1. Get your API key from [Google AI Studio](https://makersuite.google.com/app/apikey)
2. Create a `Constants.kt` file in `app/src/main/java/com/example/chatbot/utils/`
3. Add your API key 

### API Features Used
- Model: gemini-pro
- Endpoints: 
  - Content generation
  - Text responses
- Error handling and retry logic
- Asynchronous communication

## How Google Gemini AI API Works

### 1. API Setup
```kotlin
// Required dependency
implementation 'com.google.ai.client.generativeai:generativeai:0.1.1'

// Model initialization
val generativeModel = GenerativeModel(
    modelName = "gemini-pro",
    apiKey = YOUR-API-KEY
)
```

2. **Message Processing Flow**
- User sends message through UI
- ViewModel prepares API request
- Async call to Gemini API
- Response handling and state update
- UI updates with response


## Setup Instructions

1. Clone the repository
2. Set up your Gemini API key as described above
3. Open the project in Android Studio
4. Sync Gradle files
5. Run the app on an emulator or physical device

## Requirements

- Android Studio Arctic Fox or newer
- Minimum SDK: 26
- Target SDK: 35
- Kotlin 1.9.0 or newer

## Contributing

Feel free to submit issues and enhancement requests.
