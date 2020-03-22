package com.melvic.archia.ast

sealed trait BoostMode

object BoostMode {
  case object Multiply extends BoostMode
  case object Replace extends BoostMode
  case object Sum extends BoostMode
  case object Avg extends BoostMode
  case object Max extends BoostMode
  case object Min extends BoostMode
}
