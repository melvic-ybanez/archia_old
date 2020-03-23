package com.melvic.archia.ast.fulltext

import com.melvic.archia.ast.ParamValues.{FuzzinessValue, MinimumShouldMatchValue, RewriteValue}
import com.melvic.archia.ast.fulltext.Params.MatchField.Operator.OperatorValue

object Params {
  sealed trait MatchField

  object MatchField {
    final case class Analyzer(value: String) extends MatchField
    final case class AutoGenerateSynonymsPhraseQuery(value: Boolean) extends MatchField
    final case class Fuzziness(value: FuzzinessValue) extends MatchField
    final case class MaxExpansions(value: Int) extends MatchField
    final case class PrefixLength(value: Int) extends MatchField
    final case class Transpositions(value: Boolean) extends MatchField
    final case class FuzzyRewrite(value: RewriteValue) extends MatchField
    final case class Lenient(value: Boolean) extends MatchField
    final case class Operator(value: OperatorValue) extends MatchField
    final case class MinimumShouldMatch(value: MinimumShouldMatchValue) extends MatchField

    object Operator {
      sealed trait OperatorValue

      case object Or extends OperatorValue
      case object And extends OperatorValue
    }
  }
}
