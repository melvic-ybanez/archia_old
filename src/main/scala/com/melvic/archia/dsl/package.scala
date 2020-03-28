package com.melvic.archia

package object dsl extends MatchDSL with Params {
  type ParseResult[A] = Either[Error, A]
}
