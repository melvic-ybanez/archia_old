package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.FullText.Match
import com.melvic.archia.ast.fulltext.Params.MatchParam._
import com.melvic.archia.dsl.implicits._
import com.melvic.archia.dsl.ops.{TreeOps, LeafCOps, LeafOps}

import scala.annotation.tailrec
import scala.language.implicitConversions

trait MatchDSL {
  implicit class MatchFieldOps(fieldName: String) extends TreeOps[MatchFieldParam, MatchField] {
    override def ::=(params: Vector[MatchFieldParam]) = {
      type Params = Vector[MatchFieldParam]

      @tailrec
      def fetchQueryField(acc: Params, params: Params): (Option[QueryField], Params) =
        params match {
          case Vector() => (None, acc)
          case param +: rest =>
            param.select[QueryField] match {
              case query @ Some(_) => (query, acc ++ rest)
              case _ => fetchQueryField(param +: acc, rest)
            }
        }

      val (queryField, extras) = fetchQueryField(Vector(), params)

      for {
        query <- queryField.require("Query")
        field <- MatchField(fieldName, query, extras).!
      } yield field
    }
  }
}

object MatchDSL {
  sealed trait _match

  object _match extends _match {
    implicit class matchOps(value: _match) extends LeafOps[MatchField, MatchField] {
      override def :=(value: MatchField) = value.!
    }
  }
}
