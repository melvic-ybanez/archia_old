package com.melvic.archia.ast.compound

sealed trait DecayFunctionType

object DecayFunctionType {
  case object Linear extends DecayFunctionType
  case object Exp extends DecayFunctionType
  case object Gauss extends DecayFunctionType
}
