package com.melvic.archia.dsl

import shapeless.Coproduct
import shapeless.ops.coproduct.Inject

trait SingleValueOp[C <: Coproduct, O] {
  def ::=(value: C): ParseResult[O]

  def :=[A](value: A)(implicit inject: Inject[C, A]): ParseResult[O] =
    ::=(value.as[C])

  def :=[A](result: ParseResult[A])(implicit inject: Inject[C, A]): ParseResult[O] =
    result.flatMap(:=[A])
}