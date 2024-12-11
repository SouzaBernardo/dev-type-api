package com.dev.type.api.request

data class ResultRequest(
    val userWords: List<String>,
    val correctWords: List<String>,
    val time: Int
)
