package com.melvic.archia.ast.compound

import com.melvic.archia.ast.Query

final case class Function(
  filter: Query,
  weight: Int,
  scoreFunction: Option[ScoreFunction] = None
)
