package com.jvmlab.mikro

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.jvmlab.mikro.plugins.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    encodeDefaults = true
                }
            )
        }
        configureRouting()
    }.start(wait = true)
}
