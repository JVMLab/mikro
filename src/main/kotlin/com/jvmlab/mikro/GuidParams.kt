package com.jvmlab.mikro

import kotlinx.serialization.*
import java.nio.ByteBuffer
import java.util.*


@Serializable
data class GuidParams(
  val prefix: String = "",
  val suffix: String = ""
) {
  @Transient
  private val encoder = Base64.getUrlEncoder()

  fun guid(): Guid {
    val uuid = UUID.randomUUID()
    val buffer = ByteBuffer.wrap(ByteArray(16))

    buffer.putLong(uuid.mostSignificantBits)
    buffer.putLong(uuid.leastSignificantBits)

    return Guid(
      raw = uuid.toString(),
      hex = prefix
          + uuid.mostSignificantBits.toULong().toString(16)
          + uuid.leastSignificantBits.toULong().toString(16)
          + suffix,
      b64 = prefix + encoder.encodeToString(buffer.array()).dropLast(2) + suffix
    )
  }
}