package com.melvic.archia

import com.melvic.archia.dsl.Errors.MissingField
import shapeless.{:+:, CNil}

package object dsl extends implicits with MatchDSL {
  type ParseResult[A] = Either[Vector[Error], A]
  type Error = MissingField :+: CNil
}
