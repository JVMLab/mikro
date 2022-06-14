package com.jvmlab.mikro.plugins

import com.jvmlab.mikro.Guid
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
    routing {
        get("/guid") {
            call.respond(Guid())
        }
    }
}
