package com.melvic.archia.ast.compound

import com.melvic.archia.ast.Clause

final case class Function(
  filter: Clause,
  weight: Int,
  scoreFunction: Option[ScoreFunction] = None
)
