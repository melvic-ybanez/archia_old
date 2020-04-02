package com.melvic.archia

import shapeless.Coproduct
import shapeless.ops.coproduct.Inject

trait implicits {
  implicit class CoproductOps[A](value: A) {
    def as[C <: Coproduct](implicit inject: Inject[C, A]): C =
      inject(value)
  }
}

object implicits extends implicits
