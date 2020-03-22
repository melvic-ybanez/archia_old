package com.melvic.archia.ast

sealed trait FieldModifier

object FieldModifier {
  case object None extends FieldModifier
  case object Log extends FieldModifier
  case object Log1p extends FieldModifier
  case object Log2p extends FieldModifier
  case object Ln extends FieldModifier
  case object Ln1p extends FieldModifier
  case object Ln2p extends FieldModifier
  case object Square extends FieldModifier
  case object Sqrt extends FieldModifier
  case object Reciprocal extends FieldModifier
}
