package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.Params.MatchParam.{MatchFieldParam, QueryField, QueryFieldValue}
import implicits._

sealed trait query

object query extends query {
  implicit class queryOps(value: query) extends SingleValueOp[QueryFieldValue, QueryField] {
    override type Context = MatchFieldParam
    override def :=(value: QueryFieldValue) = QueryField(value).!
  }
}
