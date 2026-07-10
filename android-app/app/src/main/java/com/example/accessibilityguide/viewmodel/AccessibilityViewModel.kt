package com.example.accessibilityguide.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.accessibilityguide.model.AccessibilityRequest
import com.example.accessibilityguide.model.AccessibilityResponse
import com.example.accessibilityguide.network.RetrofitClient
import android.util.Log


class AccessibilityViewModel : ViewModel() {

    // ✅ Store user inputs
    var visionType by mutableStateOf("")
    var eyeStrain by mutableStateOf("")
    var usage by mutableStateOf<List<String>>(emptyList())
    var features by mutableStateOf<List<String>>(emptyList())

    // ✅ API response
    var response by mutableStateOf<AccessibilityResponse?>(null)
        private set

    /* fun analyze() {
        viewModelScope.launch {
            try {
                response = RetrofitClient.api.analyzeAccessibility(
                    AccessibilityRequest(
                        vision_type = visionType,
                        eye_strain = eyeStrain,
                        usage = usage,
                        features = features
                    )
                )
            } catch (e: Exception) {
                Log.e("API_ERROR",e.toString())
            }
        }
    }
} */
    fun analyze() {
        viewModelScope.launch {
            Log.d("DEBUG_INPUT", "vision=$visionType")
            Log.d("DEBUG_INPUT", "eye=$eyeStrain")
            Log.d("DEBUG_INPUT", "usage=$usage")
            Log.d("DEBUG_INPUT", "features=$features")
            try {
                Log.d("API_CALL", "Sending request:")
                Log.d(
                    "API_CALL",
                    "vision=$visionType eye=$eyeStrain usage=$usage features=$features"
                )

                response = RetrofitClient.api.analyzeAccessibility(
                    AccessibilityRequest(
                        vision_type = visionType,
                        eye_strain = eyeStrain,
                        usage = usage,
                        features = features
                    )
                )

                Log.d("API_CALL", "Response received: $response")

            } catch (e: Exception) {
                Log.e("API_ERROR", e.toString())
            }
        }
    }
}