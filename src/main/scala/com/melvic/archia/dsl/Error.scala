package com.melvic.archia.dsl

sealed trait Error

object Error {
  final case class MissingField(fieldName: String) extends Error
}
