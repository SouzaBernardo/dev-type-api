package com.dev.type.api.service

import com.dev.type.api.client.ai.AIClient
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentMap


@Service
class AIService(
    @Autowired private val aiClient: AIClient,
    @Autowired private val cache: ConcurrentMap<String, List<String>>
) {
    suspend fun getWords(language: String): List<String> {
        if (cache.containsKey(language)) return cache[language]?.shuffled()!!
        val words = aiClient.getWords(language)
        cache[language] = words
        return words.shuffled()
    }
}