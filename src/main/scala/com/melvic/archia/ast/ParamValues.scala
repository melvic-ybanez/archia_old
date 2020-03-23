package com.melvic.archia.ast

object ParamValues {
  sealed trait RewriteValue
  sealed trait FuzzinessValue
  sealed trait MinimumShouldMatchValue

  object FuzzinessValue {
    case object Zero extends FuzzinessValue
    case object One extends FuzzinessValue
    case object Two extends FuzzinessValue
    final case class Auto(
      low: Option[Int] = None,
      high: Option[Int] = None
    ) extends FuzzinessValue
  }

  object RewriteValue {
    case object ConstantScore extends RewriteValue
    case object ConstantScoreBoolean extends RewriteValue
    case object ScoringBoolean extends RewriteValue
    case object TopTermsBlendedFreqsN extends RewriteValue
    case object TopTermsBoostN extends RewriteValue
    case object TopTermsN extends RewriteValue
  }

  object MinimumShouldMatchValue {
    trait NonConditions
    final case class Integer(value: Int) extends MinimumShouldMatchValue with NonConditions
    final case class Percentage(value: Int) extends MinimumShouldMatchValue with NonConditions
    final case class Conditions(values: (Int, NonConditions)) extends MinimumShouldMatchValue
  }
}
