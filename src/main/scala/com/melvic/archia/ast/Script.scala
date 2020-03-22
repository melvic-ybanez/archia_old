package com.melvic.archia.ast

final case class Script(
  source: Source,
  params: Vector[KeyValue]
)
