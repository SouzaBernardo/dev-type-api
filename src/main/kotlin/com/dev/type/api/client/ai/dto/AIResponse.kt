package com.dev.type.api.client.ai.dto

import kotlinx.serialization.Serializable

@Serializable
data class AIResponse(val words: List<String>)
