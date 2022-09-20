package leetCode75.level1.day6

import scala.annotation.tailrec
import scala.collection.mutable

object NaryTreePreorder extends App {

  def preorder(root: Node): List[Int] = {
    if (root == null) return List.empty
    List(root.value) ++ root.children.flatMap(child => preorder(child))
  }

  def preorderIterative(root: Node): List[Int] = {
    if (root == null) return List.empty

    val stack = mutable.Stack(root)

    @tailrec
    def rec(acc: List[Int] = List.empty): List[Int] = {
      if (stack.isEmpty) return acc

      val currentNode = stack.pop()
      val newAcc = acc :+ currentNode.value
      currentNode.children.reverse.foreach(kid => stack.push(kid))

      rec(newAcc)
    }

    rec()
  }


  val secondKids = List(new Node(5), new Node(6))
  val firstKid = new Node(3)
  firstKid.children = secondKids
  val firstKids = List(firstKid, new Node(2), new Node(4))
  val root = new Node(1)
  root.children = firstKids

  println(preorder(root))
  println(preorderIterative(root))
}


class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}
