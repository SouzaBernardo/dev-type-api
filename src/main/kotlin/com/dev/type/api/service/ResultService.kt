package com.dev.type.api.service

import com.dev.type.api.request.ResultRequest
import com.dev.type.api.response.ResultResponse
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service

const val FIVE = 5
const val HUNDRED = 100

@Service
class ResultService {

    suspend fun calculate(request: ResultRequest): ResultResponse {
        return coroutineScope {
            val (total, erros, hits) = calculateGenericResults(request.userWords, request.correctWords)
            val acc = calculateACC(request.userWords, request.correctWords)
            val wpm = calculateWPM(hits, request.time)
            return@coroutineScope ResultResponse(acc, wpm, total, erros, hits)
        }
    }

    private fun calculateACC(userWords: List<String>, correctWords: List<String>): Int {
        val totalCorrectWords = correctWords.size
        val totalWordsWritten = userWords.mapIndexed { index, userWord ->
            if (correctWords[index] == userWord) 1 else 0
        }.sum()
        if (totalWordsWritten == 0) return 0
        return (totalCorrectWords / totalWordsWritten) * HUNDRED
    }

    private fun calculateWPM(totalCorrectChars: Int, time: Int): Int {
        return totalCorrectChars / (FIVE * time)
    }

    private fun calculateGenericResults(userWords: List<String>, correctWords: List<String>): GenericResults {
        var totalCharsWritten = 0
        var totalCorrectChars = 0
        var totalWrongChars = 0
        correctWords.forEachIndexed { indexW, word ->
            val userWord = userWords[indexW]
            word.forEachIndexed() { indexC, char ->
                if (userWord[indexC] == char) {
                    totalCorrectChars++
                } else {
                    totalWrongChars++
                }
                totalCharsWritten++
            }
        }
        return GenericResults(
            total = totalCharsWritten,
            hits = totalCorrectChars,
            erros = totalWrongChars
        )
    }
}

data class GenericResults(val total: Int, val erros: Int, val hits: Int)
