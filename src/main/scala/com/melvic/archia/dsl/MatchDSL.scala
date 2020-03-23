package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.FullText.Match
import com.melvic.archia.ast.fulltext.Params.MatchParam.MatchField

trait MatchDSL {
  def _match(field: MatchField): Match = Match(field)
}
