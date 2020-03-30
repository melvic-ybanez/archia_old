package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.Params.MatchParam.{Analyzer, QueryField, QueryFieldValue}
import com.melvic.archia.dsl.ops.{LeafCoproductOps, LeafOps}

trait Keys {
  object query {
    implicit class queryOps(value: query.type) extends LeafCoproductOps[QueryFieldValue, QueryField] {
      override def ::=(value: QueryFieldValue) = QueryField(value).!
    }
  }

  object analyzer {
    implicit class analyzerOps(value: analyzer.type) extends LeafOps[String, Analyzer] {
      override def :=(value: String) = Analyzer(value).!
    }
  }
}

object Keys extends Keys
