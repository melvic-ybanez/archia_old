package com.melvic.archia.dsl.ops

import com.melvic.archia.ast.fulltext.Params.MatchParam.{QueryField, QueryFieldValue}
import com.melvic.archia.dsl._
import com.melvic.archia.dsl.ParseResult
import shapeless.Coproduct
import shapeless.ops.coproduct.Inject

trait LeafCOps[C <: Coproduct, O] {
  def ::=(value: C): ParseResult[O]

  def :=[A](value: A)(implicit inject: Inject[C, A]): ParseResult[O] =
    ::=(value.as[C])

  def :=[A](result: ParseResult[A])(implicit inject: Inject[C, A]): ParseResult[O] =
    result.flatMap(:=[A])
}