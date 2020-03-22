package com.melvic.archia.ast.compound

import com.melvic.archia.ast.Score

sealed trait ScoreFunction

object ScoreFunction {
  final case class ScriptScore(script: Script) extends ScoreFunction
  final case class Weight(score: Score) extends ScoreFunction
  final case class RandomScore(seed: Option[Int], field: Option[String]) extends ScoreFunction
  final case class FieldValueFactor(
    field: String,
    factor: Float = 1,
    modifier: FieldModifier = FieldModifier.None,
    missing: Int = 0
  ) extends ScoreFunction

  final case class DecayFunction(
    decayFunction: DecayFunctionType,
    field: DecayFunctionField,
    multiValueMode: Option[MultiValueMode],

  ) extends ScoreFunction
}
