package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.Params.MatchParam.{MatchFieldParam, QueryField, QueryFieldValue}
import implicits._
import shapeless.ops.coproduct.Inject

sealed trait query

object query extends query {
  implicit class queryOps(value: query) extends SingleValueOp[QueryFieldValue, QueryField] {
    override def ::=(value: QueryFieldValue) = QueryField(value).!
  }
}
