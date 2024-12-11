package com.dev.type.api.response

data class ResultResponse(
    val acc: Int,
    val wpm: Int,
    val total: Int,
    val errors: Int,
    val hits: Int
)