package com.melvic.archia.dsl

import shapeless.Coproduct

trait SingleValue[A, C] {
  def := : A => C
}
