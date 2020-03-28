package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.FullText.Match
import com.melvic.archia.ast.fulltext.Params.MatchParam.{MatchField, MatchFieldParam, QueryField, QueryFieldValue}
import com.melvic.archia.dsl.Error.MissingField
import .query
import com.melvic.archia.dsl.MatchDSL.MatchParam.query
import implicits._
import shapeless.{:+:, CNil, Poly1}
import shapeless.ops.coproduct.{Inject, Selector}

import scala.annotation.tailrec
import scala.language.implicitConversions

trait MatchDSL {
  def _match(field: MatchField): ParseResult[Match] = Match(field).!

  implicit class MatchFieldOps(fieldName: String) extends MultiValue[MatchFieldParam, MatchField] {
    override def :=(params: Vector[MatchFieldParam]) = {
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
