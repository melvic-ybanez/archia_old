package com.melvic.archia.ast

final case class DecayFunctionField(
  fieldName: String,
  scale: String,
  offset: String,
  decay: Float,
)
