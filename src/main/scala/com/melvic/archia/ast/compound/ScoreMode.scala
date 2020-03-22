package com.melvic.archia.ast.compound

sealed trait ScoreMode

object ScoreMode {
  case object Multiply extends ScoreMode
  case object Sum extends ScoreMode
  case object Avg extends ScoreMode
  case object First extends ScoreMode
  case object Max extends ScoreMode
  case object Min extends ScoreMode
}
