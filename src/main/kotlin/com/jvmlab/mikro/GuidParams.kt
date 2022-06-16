package com.jvmlab.mikro

import kotlinx.serialization.*
import java.util.*


@Serializable
data class GuidParams(
  val prefix: String = "",
  val suffix: String = ""
) {

  fun guid(): Guid {
    val uuid = UUID.randomUUID()
    return Guid(
      raw = uuid.toString(),
      hex = prefix
          + uuid.mostSignificantBits.toULong().toString(16)
          + uuid.leastSignificantBits.toULong().toString(16)
          + suffix
    )
  }
}