package com.example.accessibilityguide.model

data class AccessibilityRequest(
    val vision_type: String,
    val eye_strain: String,
    val usage: List<String>,
    val features: List<String>
)

data class Recommendation(
    val title: String,
    val description: String,
    val reason: String
)

data class AccessibilityResponse(
    val recommendations: List<Recommendation>,
    val disclaimer: String
)