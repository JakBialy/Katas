package leetCode75.level1.day3

import scala.annotation.tailrec

object MergeTwoLists extends App {

  def mergeTwoListsMap(list1: ListNode, list2: ListNode): ListNode = {

    //    shameful mutation inside
    val accNode = new ListNode(0, null)

    @tailrec
    def reverseRec(list1: ListNode = list1, list2: ListNode = list2, next: ListNode): Unit = {
      if (list1 == null && list2 == null) return

      if (list1 == null) {
        next.next = list2
        return
      }
      else if (list2 == null) {
        next.next = list1
        return
      }

      lazy val isBigger: Boolean = list1.x > list2.x

      val nextList1 = if (isBigger) list1 else list1.next
      val nextList2 = if (isBigger) list2.next else list2

      if (isBigger) next.next = new ListNode(list2.x, null)
      else next.next = new ListNode(list1.x, null)

      reverseRec(nextList1, nextList2, next.next)
    }

    reverseRec(list1, list2, accNode)
    accNode.next
  }


  val list3 = new ListNode(1, new ListNode(2, new ListNode(4, null)))
  val list4 = new ListNode(1, new ListNode(3, new ListNode(4, null)))

  val list1 = new ListNode(1, null)
  val list2 = null

  println(mergeTwoListsMap(list1, list2))
  println(mergeTwoListsMap(list3, list4))

}


class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

//  override def toString: String = s"$x${untilNull(next)}"

//  def untilNull(x: ListNode, acc: String = ""): String = {
//    if (x == null) acc
//    else untilNull(x.next, acc + s",${x.x}")
//  }
}