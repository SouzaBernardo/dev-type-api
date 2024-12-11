package com.dev.type.api.controller

import com.dev.type.api.request.ResultRequest
import com.dev.type.api.response.ResultResponse
import com.dev.type.api.service.ResultService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/result")
class ResultController(
    @Autowired val resultService: ResultService
) {
    @PostMapping
    suspend fun calculateResult(@Valid @RequestBody request: ResultRequest) = resultService.calculate(request)
}