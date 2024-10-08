package com.dev.type.api.client.ai.gemini

import com.dev.type.api.client.ai.AIClient
import com.dev.type.api.client.ai.gemini.request.Request
import com.dev.type.api.client.ai.gemini.response.Response
import com.dev.type.api.properties.AIClientProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.server.ResponseStatusException

@Component
class GeminiClient(
    @Autowired val restClient: RestClient,
    @Autowired val aiClientProperties: AIClientProperties
) : AIClient {
    override suspend fun getWords(language: String): List<String> {
        val prompt = String.format(aiClientProperties.prompt, language)
        val request = Request.getRequest(prompt)
        val response = restClient.post()
            .body(request)
            .retrieve()
            .toEntity(Response::class.java)

        if (response.statusCode != HttpStatusCode.valueOf(200)) {
            throw ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, response.body.toString())
        }

        val body = response.body!!
        return Json.decodeFromString<List<String>>(body.getResponse())
    }
}

