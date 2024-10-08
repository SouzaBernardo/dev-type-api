package com.dev.type.api

import com.dev.type.api.properties.AIClientProperties
import com.dev.type.api.properties.ControllerToggle
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching


@SpringBootApplication
@EnableConfigurationProperties(value = [AIClientProperties::class, ControllerToggle::class])
class ApiApplication

fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
