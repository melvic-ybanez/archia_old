package com.melvic.archia.ast

sealed trait Clause

object Clause {
  sealed trait Leaf extends Clause
  sealed trait Compound extends Clause


}