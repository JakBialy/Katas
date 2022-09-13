package leetCode75.level1.day3

import scala.annotation.tailrec

object ReverseLinkedList extends App {


  def reverseList(head: ListNode): ListNode = {

    @tailrec
    def reverseRec(current: ListNode = head, previous: ListNode = null, acc: ListNode = null): ListNode = {
      if (current == null) return acc
      val reversedList = if (acc == null) new ListNode(current.x, previous) else new ListNode(current.x, acc)
      reverseRec(current.next, current, reversedList)
    }

    reverseRec()
  }


  val node = new ListNode(1, new ListNode(2, new ListNode(3, null)))
  println(reverseList(node).toString)
}