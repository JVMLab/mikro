package com.jvmlab.mikro

import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import kotlin.test.*


class ApplicationTest {

  @Test
  fun testRoot() = testApplication {
    val response = client.get("/")
    assertEquals(HttpStatusCode.OK, response.status)
    assertEquals("Hello, World!", response.bodyAsText())
  }

  @Test
  fun testGuidGet() = testApplication {
    val client = createClient {
      install(ContentNegotiation) {
        json()
      }
    }
    val response = client.get("/guid")
    assertEquals(HttpStatusCode.OK, response.status)
    val guid = response.body<Guid>()
    assertEquals(36, guid.raw.length)
    assertEquals(32, guid.hex.length)
    assertEquals(22, guid.b64.length)
  }

  @Test
  fun testGuidPost() = testApplication {
    val client = createClient {
      install(ContentNegotiation) {
        json()
      }
    }
    val response = client.post("/guid") {
      contentType(ContentType.Application.Json)
      setBody(GuidParams())
    }
    assertEquals(HttpStatusCode.OK, response.status)
    val guid = response.body<Guid>()
    assertEquals(36, guid.raw.length)
    assertEquals(32, guid.hex.length)
    assertEquals(22, guid.b64.length)
  }
}