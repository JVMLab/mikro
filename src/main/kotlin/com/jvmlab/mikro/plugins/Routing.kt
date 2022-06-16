package com.jvmlab.mikro.plugins

import com.jvmlab.mikro.Guid
import com.jvmlab.mikro.GuidParams
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*


fun Application.configureRouting() {

  routing {
    get("/") {
      call.respondText("Hello World!")
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
