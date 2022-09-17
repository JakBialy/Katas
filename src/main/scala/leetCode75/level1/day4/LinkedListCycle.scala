package leetCode75.level1.day4

import leetCode75.level1.day3.ListNode

import scala.annotation.tailrec
import scala.collection.immutable.HashSet

object LinkedListCycle extends App {

  @tailrec
  def findCycleLength(static: ListNode, moving: ListNode, acc: Int): Int = {
    if (static == moving) return acc
    findCycleLength(static, moving.next, acc + 1)
  }

  @tailrec
  def findLoopStart(head: ListNode, forward: ListNode): ListNode = {
    if (head == forward) return head
    findLoopStart(head.next, forward.next)
  }

  @tailrec
  def moveByXCycles(current: ListNode, toGo: Int): ListNode = {
    if (toGo == 0) return current
    moveByXCycles(current.next, toGo - 1)
  }

  def detectCycle(head: ListNode): ListNode = {
    if (head == null || head.next == null) return null

    //    remember about hash codes and memory refs!
    @tailrec
    def rec(slow: ListNode, fast: ListNode): ListNode = {
      if (fast == null || fast.next == null || fast.next.next == null) return null
      else if (slow == fast) {
        val length = findCycleLength(slow, fast.next, 1)
        return findLoopStart(head, moveByXCycles(head, length))
      }
      rec(slow.next, fast.next.next)
    }

    rec(head, head.next.next)
  }

//  hash set approach
//  flag approach

  val headNode = new ListNode(1, null)
  val next = new ListNode(2, headNode)
  headNode.next = next
  next.next = new ListNode(3, next)
  println(detectCycle(headNode).x)
}
