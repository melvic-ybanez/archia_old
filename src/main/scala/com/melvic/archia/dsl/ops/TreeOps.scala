package com.melvic.archia.dsl.ops

import com.melvic.archia.dsl.ParseResult
import shapeless.Coproduct
import shapeless.ops.coproduct.Inject
import com.melvic.archia.dsl._

trait TreeOps[C <: Coproduct, O] {
  def ::=(params: Vector[C]): ParseResult[O]

  def :=[A](params: ParseResult[A]*)(implicit inject: Inject[C, A]): ParseResult[O] = {
    val (errors, validParams) = params.partitionMap {
      case Left(errors) => Left(errors)
      case Right(param) => Right(param)
    }

    val result = ::=(validParams.map(_.as[C]).toVector)
    result.fold[ParseResult[O]](errs => Left(errs ++ errors.flatten), Right(_))
  }
}
