package com.melvic.archia.dsl

import shapeless.Coproduct
import shapeless.ops.coproduct.Inject

trait SingleValueOp[I, O] {
  type Context <: Coproduct

  def :=(value: I): ParseResult[O]

  def :=(value: ParseResult[I])(implicit inject: Inject[Context, O]): ParseResult[Context] =
    value.flatMap(:=(_).map(_.as[Context]))
}
