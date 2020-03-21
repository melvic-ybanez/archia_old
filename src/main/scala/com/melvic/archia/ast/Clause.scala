package com.melvic.archia.ast

sealed trait Clause

object Clause {
  trait Leaf extends Clause
  trait Compound extends Clause
  case object NoClause extends Clause
}