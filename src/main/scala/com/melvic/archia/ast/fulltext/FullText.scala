package com.melvic.archia.ast.fulltext

import com.melvic.archia.ast.Query

sealed trait FullText extends Query

object FullText {
  final case class Match(
    field: String,
    query: QueryField,
  )
}
