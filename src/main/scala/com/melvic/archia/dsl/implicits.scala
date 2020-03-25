package com.melvic.archia.dsl

import com.melvic.archia.dsl.Error.MissingField

object implicits {
  implicit class ResultOps[A](value: A) {
    def ! = Right(value)
  }

  implicit class OptionOps[A](value: Option[A]) {
    def require(fieldName: String): Either[MissingField, A] =
      value.toRight(MissingField(fieldName))
  }

  implicit class VectorOps[A](values: Vector[A]) {
    def require(fieldName: String): Either[MissingField, A] =
      values.headOption.require(fieldName)
  }
}
