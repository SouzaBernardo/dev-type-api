package com.dev.type.api.client.ai


interface AIClient {
    suspend fun getWords(language: String): List<String>
}