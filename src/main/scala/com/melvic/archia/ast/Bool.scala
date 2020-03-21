package com.melvic.archia.ast

import com.melvic.archia.ast.Clause.{Compound, NoClause}

final case class Bool(
  must: Vector[Clause] = Vector.empty,
  should: Vector[Clause] = Vector.empty,
  mustNot: Vector[Clause] = Vector.empty,
  filter: Vector[Clause] = Vector.empty,
  minimumShouldMatch: Int = 0
) extends Compound
