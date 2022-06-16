package com.jvmlab.mikro

import kotlinx.serialization.*


@Serializable
data class Guid(
  val raw: String,
  val hex: String
)
