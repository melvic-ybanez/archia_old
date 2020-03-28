package com.melvic.archia.dsl

import shapeless.Coproduct

trait MultiValueOp[I, O] {
  type Context <: Coproduct

  def ::=(params: Vector[I]): ParseResult[Context]

  def :=(params: Vector[ParseResult[I]]): ParseResult[Context] = {
    val (errors, validParams) = params.partitionMap {
      case Left(errors) => Left(errors)
      case Right(param) => Right(param)
    }

    val result = ::=(validParams)
    result.fold(errs => Left(errs ++ errors.flatten), Right(_))
  }

  def :=(params: ParseResult[I]*): ParseResult[Context] = :=(params.toVector)
  def :=(params: I*): ParseResult[Context] = ::=(params.toVector)
}
