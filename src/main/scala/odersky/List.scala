//package odersky
//
//import scala.annotation.tailrec
//
//trait List[T] {
//  def isEmpty: Boolean
//
//  def head: T
//
//  def tail: List[T]
//
//  def apply(): Nil.type = {
//    Nil
//  }
//
//  def apply[T](first: T) = {
//    List[T](Const(first, Nil[T]()))
//  }
//
//  def apply[T](first: T, second: T): List[T] = {
//    List[T](Const(first, Const(second, Nil[T]())))
//  }
//
//}
//
//case class Const[T](val head: T, val tail: List[T]) extends List[T] {
//  def isEmpty = false
//}
//
//case class Nil[T]() extends List[T] {
//  override def isEmpty: Boolean = true
//
//  override def head: T = throw new Exception("empty!")
//
//  override def tail: List[T] = throw new Exception("tail of NIL!")
//}
//
//object dff extends App {
//  val list = Const[Int](1, Const(2, Const(3, Nil[Int]())))
//
//  val resss = List[String]("s", "s")
//
//  @tailrec
//  def nth[T](int: Int, list: List[T]): T = {
//    if (int == 0) list.head
//    else {
//      nth(int - 1, list.tail)
//    }
//  }
//
//  println(nth(1, list))
//}
//
//
