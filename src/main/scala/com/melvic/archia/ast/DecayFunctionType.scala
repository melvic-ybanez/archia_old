package com.melvic.archia.ast

sealed trait DecayFunctionType

object DecayFunctionType {
  case object Linear extends DecayFunctionType
  case object Exp extends DecayFunctionType
  case object Gauss extends DecayFunctionType
}
