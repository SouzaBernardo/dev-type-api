package com.dev.type.api.config

import com.dev.type.api.properties.AIClientProperties
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig(
    @Autowired val aiClientProperties: AIClientProperties
) {
    @Bean
    fun restClient(): RestClient {
        val properties = aiClientProperties.origins[aiClientProperties.default]!!
        return RestClient
            .builder()
            .baseUrl("${properties.url}${properties.token}")
            .defaultHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
            .build()
    }
}