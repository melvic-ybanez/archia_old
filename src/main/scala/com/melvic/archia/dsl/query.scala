package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.Params.MatchParam.{QueryField, QueryFieldValue}
import com.melvic.archia.dsl.ops.LeafCoproductOps

sealed trait query

object query extends query {
  implicit class queryOps(value: query) extends LeafCoproductOps[QueryFieldValue, QueryField] {
    override def ::=(value: QueryFieldValue) = QueryField(value).!
  }
}
