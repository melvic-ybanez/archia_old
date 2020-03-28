package com.melvic.archia.ast.fulltext

import java.util.Date

import com.melvic.archia.ast.{ESDate, ESNumeric}
import com.melvic.archia.ast.ParamValues.{FuzzinessValue, MinimumShouldMatchValue, RewriteValue}
import com.melvic.archia.ast.fulltext.Params.MatchParam.Operator.{And, Or}
import com.melvic.archia.ast.fulltext.Params.MatchParam.ZeroTermsQuery.{All, NoTerms}
import shapeless.{:+:, CNil, Inl}

object Params {
  object MatchParam {
    final case class MatchField(
      name: String,
      query: QueryField,
      params: Vector[MatchFieldParam]
    )

    type MatchFieldParam = QueryField :+: Analyzer :+: AutoGenerateSynonymsPhraseQuery :+:
      Fuzziness :+: MaxExpansions :+: PrefixLength :+: Transpositions :+: FuzzyRewrite :+:
      Lenient :+: Operator :+: MinimumShouldMatch :+: ZeroTermsQuery :+: CutOffFrequency :+: CNil

    type QueryFieldValue = String :+: ESNumeric :+: ESDate :+: CNil

    final case class QueryField(value: QueryFieldValue)
    final case class Analyzer(value: String)
    final case class AutoGenerateSynonymsPhraseQuery(value: Boolean)
    final case class Fuzziness(value: FuzzinessValue)
    final case class MaxExpansions(value: Int)
    final case class PrefixLength(value: Int)
    final case class Transpositions(value: Boolean)
    final case class FuzzyRewrite(value: RewriteValue)
    final case class Lenient(value: Boolean)
    final case class Operator(value: Or.type :+: And.type :+: CNil)
    final case class MinimumShouldMatch(value: MinimumShouldMatchValue)
    final case class ZeroTermsQuery(value: NoTerms.type :+: All.type :+: CNil)
    final case class CutOffFrequency(value: Float)

    object Operator {
      case object Or
      case object And
    }

    object ZeroTermsQuery {
      case object NoTerms
      case object All
    }
  }
}
