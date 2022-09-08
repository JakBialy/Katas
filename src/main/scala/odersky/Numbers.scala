package odersky

abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = Succ(this)
  def + (that: Nat): Nat
  def - (that: Nat): Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def predecessor: Nat = throw new Exception("No predecessor")

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if(that.isZero) this else throw new Exception("No predecessor")
}

case class Succ(n: Nat) extends Nat {
  override def isZero: Boolean = false

  override def predecessor: Nat = n

  override def +(that: Nat): Nat = Succ(n + that)

  override def -(that: Nat): Nat = if(that.isZero) this else n - predecessor
}