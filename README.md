# 👁️ VisionEase – AI Powered Accessibility Assistant

VisionEase is an AI-powered Android accessibility assistant that provides personalized visual accessibility recommendations based on a user's vision preferences. It combines a modern Android application built with Jetpack Compose and a FastAPI backend to generate customized accessibility settings.

## ✨ Features

- Personalized accessibility recommendations
- Vision type selection (Normal, Positive, Negative)
- Eye strain level analysis
- Usage-based recommendations (Reading, Study, Gaming, Night Mode)
- Adjustable text size suggestions
- Dark mode recommendations
- Image enhancement suggestions
- FastAPI REST API backend
- Modern Jetpack Compose UI

## 🛠️ Tech Stack

### Frontend
- Kotlin
- Android Studio
- Jetpack Compose
- Navigation Compose
- Retrofit

### Backend
- Python
- FastAPI
- Uvicorn
- Pydantic

## 📂 Project Structure

```
VisionEase
│
├── android-app/        # Android Frontend
├── main.py             # FastAPI Backend
└── README.md
```

## 🚀 How to Run

### Backend

```bash
pip install fastapi uvicorn pydantic
python -m uvicorn main:app --reload
```

Open:

```
http://127.0.0.1:8000/docs
```

### Android App

1. Open `android-app` in Android Studio.
2. Sync Gradle.
3. Run the application on an emulator or Android device.
4. Ensure the FastAPI backend is running before using the app.

## 📸 Screenshots

Add screenshots of:
- Splash Screen
- Home Screen
- Vision Selection
- Recommendation Screen

## 📌 Future Improvements

- AI-powered recommendation engine
- Voice assistance
- Accessibility analytics
- Cloud database integration
- User profile support

