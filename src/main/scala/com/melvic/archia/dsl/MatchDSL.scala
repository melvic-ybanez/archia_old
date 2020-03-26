package com.melvic.archia.dsl

import com.melvic.archia.ast.fulltext.FullText.Match
import com.melvic.archia.ast.fulltext.Params.MatchParam.{MatchField, MatchFieldParam, QueryField}
import com.melvic.archia.dsl.Error.MissingField
import implicits._
import shapeless.Poly1

import scala.annotation.tailrec
import scala.language.implicitConversions

trait MatchDSL {
  def _match(field: MatchField): ParseResult[Match] = Match(field).!

  implicit class MatchFieldOps(fieldName: String) extends ValueSyntax[MatchFieldParam, MatchField] {
    override def ->>(params: Vector[MatchFieldParam]) = {
      type Params = Vector[MatchFieldParam]

      @tailrec
      def fetchQueryField(acc: Params, params: Params): (Option[QueryField], Params) =
        params match {
          case Vector() => (None, acc)
          case param +: rest => println(param.select[QueryField])
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
