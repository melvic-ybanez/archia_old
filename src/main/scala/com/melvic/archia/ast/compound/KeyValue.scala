package com.melvic.archia.ast.compound

trait KeyValue {
  type Key
  type Value

  def key: Key

  def value: Value
}

object KeyValue {
  def :=[K, V](k: K, v: V): KeyValue = new KeyValue {
    override type Key = K
    override type Value = V

    override def key = k
    override def value = v
  }
}
