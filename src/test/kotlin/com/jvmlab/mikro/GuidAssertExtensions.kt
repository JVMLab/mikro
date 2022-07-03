package com.jvmlab.mikro

import org.junit.jupiter.api.assertAll
import kotlin.test.assertEquals
import kotlin.test.assertTrue


fun Guid.assertBase() {
  assertAll(
    { assertEquals(36, this.raw.length) },
    { assertEquals(32, this.hex.length) },
    { assertEquals(22, this.b64.length) }
  )
}


fun Guid.assertFull(guidParams: GuidParams) {
  val extraLength = guidParams.prefix.length + guidParams.suffix.length
  assertAll(
    { assertEquals(36, this.raw.length) },
    { assertEquals(32 + extraLength, this.hex.length) },
    { assertEquals(22 + extraLength, this.b64.length) },
    { assertTrue(this.hex.startsWith(guidParams.prefix)) },
    { assertTrue(this.hex.endsWith(guidParams.suffix)) }
  )
}