package com.melvic.archia.ast.compound

import com.melvic.archia.ast.{Boost, Clause, Score}

trait Compound extends Clause

object Compound {
  final case class Bool(
    must: Vector[Clause] = Vector.empty,
    should: Vector[Clause] = Vector.empty,
    mustNot: Vector[Clause] = Vector.empty,
    filter: Vector[Clause] = Vector.empty,
    minimumShouldMatch: Float = 1.0f,
    boost: Boost = 1.0f
  ) extends Compound

  final case class Boosting(
    positive: Clause,
    negative: Clause,
    negativeBoost: Boost
  ) extends Compound

  final case class ConstantScore(filter: Clause, boost: Float = 1.0f) extends Compound

  final case class DisMax(
    queries: Vector[Clause],
    tieBreaker: Float = 0.0f,
  ) extends Compound

  final case class FunctionScore(
    query: Clause,
    boost: Boost,
    maxBoost: Boost,
    functions: Vector[Function],
    scoreMode: ScoreMode = ScoreMode.Multiply,
    boostMode: BoostMode = BoostMode.Multiply,
    minScore: Score = 0.0f
  ) extends Compound
}
