package com.dev.type.api.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("client.ai")
data class AIClientProperties(
    val prompt: String = "",
    val default: String = "",
    val origins: Map<String, Origin> = emptyMap()
)

data class Origin(val url: String, val token: String)