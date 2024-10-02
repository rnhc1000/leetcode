package org.ferreiras.leetcode;

/**
 * Given the head of a singly linked list, reverse the list,
 * and return the reversed list.
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) {
 * this.val = val;
 * this.next = next;
 * }
 * }
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */



public class ReverseLinkedList {

  public ListNode revertLinkedList(ListNode node) {

    ListNode prev = null;
    ListNode next = null;
    ListNode current = node;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }
}
