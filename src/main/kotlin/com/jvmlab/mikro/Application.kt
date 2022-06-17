package com.jvmlab.mikro

import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlinx.serialization.json.Json
import io.ktor.server.routing.*


fun main(args: Array<String>): Unit = EngineMain.main(args)


fun Application.module() {

  install(ContentNegotiation) {
    json(
      Json {
        prettyPrint = true
        encodeDefaults = true
      }
    )
  }

  routing {
    get("/") {
      call.respondText("Hello, World!")
    }

    route("/guid") {
      get {
        call.respond(GuidParams().guid())
      }

      post {
        val params = call.receive<GuidParams>()
        call.respond(params.guid())
      }
    }
  }
}

