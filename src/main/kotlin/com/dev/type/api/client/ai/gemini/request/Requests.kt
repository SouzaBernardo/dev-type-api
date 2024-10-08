package com.dev.type.api.client.ai.gemini.request

// I know, it's boring but google need this
data class Request(val contents: List<Part>){
    companion object {
        fun getRequest(prompt: String) = Request(listOf(Part(listOf(Text(prompt)))))
    }
}
data class Part(val parts: List<Text>)
data class Text(val text: String)