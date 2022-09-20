package leetCode75.level1.day6

import scala.annotation.tailrec
import scala.collection.mutable

object BinaryTreeLevelOrderTraversal extends App {

  def levelOrder(root: TreeNode): List[List[Int]] = {
    if (root == null) return List.empty

    val queue = mutable.Queue(root)

    @tailrec
    def rec(acc: List[List[Int]] = List.empty): List[List[Int]] = {
      if (queue.isEmpty) return acc
      val size = queue.size

      @tailrec
      def level(toGo: Int, acc: List[Int] = List.empty): List[Int] = {
        if (toGo <= 0) return acc
        val currentNode = queue.dequeue()
        val newAcc = acc :+ currentNode.value
        if (currentNode.left != null) queue.enqueue(currentNode.left)
        if (currentNode.right != null) queue.enqueue(currentNode.right)
        level(toGo - 1, newAcc)
      }

      val currentLevel = level(size)
      rec(acc :+ currentLevel)
    }

    rec()
  }


  val right2 = new TreeNode(7, null, null)
  val left2 = new TreeNode(15, null, null)
  val right = new TreeNode(20, left2, right2)
  val left = new TreeNode(9, null, null)
  val root = new TreeNode(3, left, right)
  println(levelOrder(root))
}


class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}