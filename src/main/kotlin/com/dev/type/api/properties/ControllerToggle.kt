package com.dev.type.api.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties("toggle.endpoints")
class ControllerToggle(
    val availableLanguageController: Boolean
)