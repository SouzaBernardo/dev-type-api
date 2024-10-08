package com.dev.type.api.controller

import com.dev.type.api.properties.ControllerToggle
import com.dev.type.api.response.LanguageWordsResponse
import com.dev.type.api.service.AIService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/languages")
class LanguageController(
    @Autowired private val aiService: AIService,
    @Autowired private val controller: ControllerToggle
) {
    @GetMapping("/{language}")
    suspend fun getWords(@PathVariable language: String): LanguageWordsResponse {
        return if (controller.availableLanguageController) {
            val words = aiService.getWords(language)
            LanguageWordsResponse(language, words)
        } else LanguageWordsResponse(language, listOf())
    }
}