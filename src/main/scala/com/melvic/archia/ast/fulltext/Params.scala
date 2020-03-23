package com.melvic.archia.ast.fulltext

import java.util.Date

import com.melvic.archia.ast.ParamValues.{FuzzinessValue, MinimumShouldMatchValue, RewriteValue}
import com.melvic.archia.ast.fulltext.Params.MatchParam.Operator.OperatorValue
import com.melvic.archia.ast.fulltext.Params.MatchParam.ZeroTermsQuery.ZeroTermsQueryValue

object Params {
  object MatchParam {
    final case class MatchField(
      name: String,
      query: QueryField,
      params: Vector[MatchFieldParam]
    )
    sealed trait MatchFieldParam

    sealed trait QueryField extends MatchFieldParam

    final case class Analyzer(value: String) extends MatchFieldParam
    final case class AutoGenerateSynonymsPhraseQuery(value: Boolean) extends MatchFieldParam
    final case class Fuzziness(value: FuzzinessValue) extends MatchFieldParam
    final case class MaxExpansions(value: Int) extends MatchFieldParam
    final case class PrefixLength(value: Int) extends MatchFieldParam
    final case class Transpositions(value: Boolean) extends MatchFieldParam
    final case class FuzzyRewrite(value: RewriteValue) extends MatchFieldParam
    final case class Lenient(value: Boolean) extends MatchFieldParam
    final case class Operator(value: OperatorValue) extends MatchFieldParam
    final case class MinimumShouldMatch(value: MinimumShouldMatchValue) extends MatchFieldParam
    final case class ZeroTermsQuery(value: ZeroTermsQueryValue) extends MatchFieldParam
    final case class CutOffFrequency(value: Float) extends MatchFieldParam

    object QueryField {
      final case class TextQuery(value: String) extends QueryField
      final case class NumberQuery(value: Double) extends QueryField
      final case class BoolQuery(value: Boolean) extends QueryField
      final case class DateQuery(value: Date) extends QueryField
    }

    object Operator {
      sealed trait OperatorValue

      case object Or extends OperatorValue
      case object And extends OperatorValue
    }

    object ZeroTermsQuery {
      sealed trait ZeroTermsQueryValue

      case object None extends ZeroTermsQueryValue
      case object All extends ZeroTermsQueryValue
    }
  }
}
