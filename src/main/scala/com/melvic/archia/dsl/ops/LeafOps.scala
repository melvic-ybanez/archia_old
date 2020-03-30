package com.melvic.archia.dsl.ops

import com.melvic.archia.dsl.ParseResult

trait LeafOps[V, O] {
  def :=(value: V): ParseResult[O]

  def :=(result: ParseResult[V]): ParseResult[O] = result.flatMap(:=)
}
