package com.example.accessibilityguide.network

import com.example.accessibilityguide.model.AccessibilityRequest
import com.example.accessibilityguide.model.AccessibilityResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AccessibilityApi {

    @POST("analyze")
    suspend fun analyzeAccessibility(
        @Body request: AccessibilityRequest
    ): AccessibilityResponse
}