package com.melvic.archia.ast

final case class Function(
  filter: Clause,
  weight: Int,
  scoreFunction: Option[ScoreFunction] = None
)
