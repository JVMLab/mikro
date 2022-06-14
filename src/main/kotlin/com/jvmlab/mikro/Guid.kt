package com.jvmlab.mikro

import java.util.*
import kotlinx.serialization.*
import kotlinx.serialization.Transient


@Serializable
class Guid() {
  @Transient
  private val uuid = UUID.randomUUID()

  val uuidString: String = uuid!!.toString()
}