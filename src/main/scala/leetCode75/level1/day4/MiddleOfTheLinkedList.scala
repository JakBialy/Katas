package leetCode75.level1.day4

import leetCode75.level1.day3.ListNode

import scala.annotation.tailrec

object MiddleOfTheLinkedList extends App {

  def middleNode(head: ListNode): ListNode = {
    @tailrec
    def rec(slow: ListNode, fast: ListNode): ListNode = {
      if (fast == null || fast.next == null) return slow
      rec(slow.next, fast.next.next)
    }

    rec(head, head)
  }


  //  val list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))
  //  val list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))))
  val list = new ListNode(1)

  println(middleNode(list))
}