package com.melvic.archia.ast.compound

sealed trait MultiValueMode

object MultiValueMode {
  case object Min extends MultiValueMode
  case object Max extends MultiValueMode
  case object Avg extends MultiValueMode
  case object Sum extends MultiValueMode
}
