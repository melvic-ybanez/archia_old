package com.melvic.archia.ast.fulltext

import java.util.Date

sealed trait QueryField {
  type FieldType

  def value: FieldType
}

object QueryField {
  trait QueryFieldWithType[A] extends QueryField {
    override type FieldType = A
  }

  final case class TextQuery(value: String) extends QueryFieldWithType[String]
  final case class NumberQuery(value: Double) extends QueryFieldWithType[Double]
  final case class BoolQuery(value: Boolean) extends QueryFieldWithType[Boolean]
  final case class DateQuery(value: Date) extends QueryFieldWithType[Date]
}
