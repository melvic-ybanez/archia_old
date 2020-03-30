package com.melvic.archia.ast.compound

import com.melvic.archia.ast.{Boost, Query}

trait Compound extends Query

object Compound {
  final case class Bool(params: Vector[BoolParam]) extends Compound

  final case class Boosting(
    positive: Query,
    negative: Query,
    negativeBoost: Boost
  ) extends Compound

  final case class ConstantScore(
    filter: Query,
    params: Vector[ConstantScoreParam]
  ) extends Compound

  final case class DisMax(
    queries: Vector[Query],
    tieBreaker: Option[Float],
  ) extends Compound

  final case class FunctionScore(
    query: Query,
    boost: Boost,
    maxBoost: Boost,
    params: Vector[FunctionScoreParam]
  ) extends Compound
}
