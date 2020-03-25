package com.melvic.archia

package object dsl extends MatchDSL {
  type ParseResult[A] = Either[Error, A]
}
