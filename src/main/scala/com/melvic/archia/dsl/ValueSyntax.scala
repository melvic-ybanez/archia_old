package com.melvic.archia.dsl

trait ValueSyntax[P, V] {
  def ->>(params: Vector[P]): ParseResult[V]

  def ->>(params: P*): ParseResult[V] = ->>(params.toVector)
}
