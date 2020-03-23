package com.melvic.archia.ast.compound

import com.melvic.archia.ast.{Query, Score}

object Params {
  sealed trait Bool
  sealed trait ConstantScore
  sealed trait FunctionScore

  object Bool {
    final case class Must(queries: Vector[Query]) extends Bool
    final case class Should(queries: Vector[Query]) extends Bool
    final case class MustNot(queries: Vector[Query]) extends Bool
    final case class Filter(queries: Vector[Query]) extends Bool
    final case class MinimumShouldWatch(value: Float) extends Bool
  }

  object FunctionScore {
    sealed trait ScoreMode extends FunctionScore
    sealed trait BoostMode extends FunctionScore
    final case class MinScore(value: Score) extends FunctionScore

    object ScoreMode {
      case object Multiply extends ScoreMode
      case object Sum extends ScoreMode
      case object Avg extends ScoreMode
      case object First extends ScoreMode
      case object Max extends ScoreMode
      case object Min extends ScoreMode
    }

    object BoostMode {
      case object Multiply extends BoostMode
      case object Replace extends BoostMode
      case object Sum extends BoostMode
      case object Avg extends BoostMode
      case object Max extends BoostMode
      case object Min extends BoostMode
    }
  }

  final case class Boost(value: Boost) extends Bool with ConstantScore
}
