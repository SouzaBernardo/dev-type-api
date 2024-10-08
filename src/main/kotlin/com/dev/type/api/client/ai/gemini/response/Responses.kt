package com.dev.type.api.client.ai.gemini.response

data class Response(val candidates: List<Candidate>) {
    fun getResponse() = candidates[0].content.parts[0].text
}
data class Candidate(val content: Content)
data class Content(val parts: List<Part>)
data class Part(val text: String)