package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.Params.MatchParam.{MatchFieldParam, QueryField, QueryFieldValue}
import com.melvic.archia.dsl.ops.SingleCoproductOp
import implicits._
import shapeless.ops.coproduct.Inject

sealed trait query

object query extends query {
  implicit class queryOps(value: query) extends SingleCoproductOp[QueryFieldValue, QueryField] {
    override def ::=(value: QueryFieldValue) = QueryField(value).!
  }
}
