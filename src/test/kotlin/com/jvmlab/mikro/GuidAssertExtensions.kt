package com.jvmlab.mikro

import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals


fun Guid.assertBase() {
  assertAll(
    { assertEquals(36, this.raw.length) },
    { assertEquals(32, this.hex.length) },
    { assertEquals(22, this.b64.length) }
  )
}