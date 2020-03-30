package com.melvic.archia.dsl.ops

import com.melvic.archia.dsl.ParseResult
import shapeless.Coproduct
import shapeless.ops.coproduct.Inject
import com.melvic.archia.dsl._

trait TreeOps[C <: Coproduct, O] {
  def ::=(params: Vector[C]): ParseResult[O]

  def :=(params: ParseResult[C]*): ParseResult[O] = {
    val (errors, validParams) = params.partitionMap {
      case Left(errors) => Left(errors)
      case Right(param) => Right(param)
    }

    val result = ::=(validParams.toVector)
    result.fold[ParseResult[O]](errs => Left(errs ++ errors.flatten), Right(_))
  }
}
