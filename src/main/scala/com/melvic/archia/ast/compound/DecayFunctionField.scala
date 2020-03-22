package com.melvic.archia.ast.compound

final case class DecayFunctionField(
  fieldName: String,
  scale: String,
  offset: String,
  decay: Float,
)
