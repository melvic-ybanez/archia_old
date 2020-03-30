package com.melvic.archia.ast.fulltext

import com.melvic.archia.ast.Query
import com.melvic.archia.ast.fulltext.Params.MatchParam.MatchField

sealed trait FullText extends Query

object FullText {
  final case class Match(field: MatchField) extends FullText
}
