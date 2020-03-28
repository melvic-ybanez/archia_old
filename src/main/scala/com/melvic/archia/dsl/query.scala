package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.Params.MatchParam.{QueryField, QueryFieldValue}

sealed trait query

object query extends query {
  implicit class queryOps(value: query) extends SingleValue[QueryFieldValue, QueryField] {
    override def := = QueryField.apply
  }
}
