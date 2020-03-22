package com.melvic.archia.ast.compound

import com.melvic.archia.ast.Source

final case class Script(
  source: Source,
  params: Vector[KeyValue]
)
