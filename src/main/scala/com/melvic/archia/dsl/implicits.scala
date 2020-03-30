package com.melvic.archia.dsl

import com.melvic.archia.dsl.Errors.MissingField
import shapeless.Coproduct
import shapeless.ops.coproduct.Inject

trait implicits {
  implicit def injectParseResult[C <: Coproduct, A](parseResult: ParseResult[A])(
    implicit inject: Inject[C, A]
  ): ParseResult[C] = parseResult.map(_.as[C])

  implicit class ResultOps[A](value: A) {
    def ! : ParseResult[A] = Right(value)
  }

  implicit class OptionOps[A](value: Option[A]) {
    def require(fieldName: String): ParseResult[A] =
      value.toRight(MissingField(fieldName).as[Error] +: Vector())
  }

  implicit class VectorOps[A](values: Vector[A]) {
    def require(fieldName: String): ParseResult[A] =
      values.headOption.require(fieldName)
  }

  implicit class CoproductOps[A](value: A) {
    def as[C <: Coproduct](implicit inject: Inject[C, A]): C =
      Inject[C, A].apply(value)
  }
}

object implicits extends implicits
