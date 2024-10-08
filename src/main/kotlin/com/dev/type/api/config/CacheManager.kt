package com.dev.type.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap


@Configuration
class CacheManager {

    @Bean
    fun concurrentMap(): ConcurrentMap<String, List<String>> {
        return ConcurrentHashMap()
    }
}