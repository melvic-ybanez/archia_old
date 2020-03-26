package com.melvic.archia

import shapeless.{:+:, CNil}

package object ast {
  type Score = Float
  type Boost = Float
  type Source = String

  type ESNumeric = Long :+: Integer :+: Short :+: Byte :+: Double :+: Float :+: CNil
  type ESDate = String :+: Long :+: Int :+: CNil
}
