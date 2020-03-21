package com.melvic.archia.ast

sealed trait Context

object Context {
  trait Query extends Context
  trait Filter extends Context
}
