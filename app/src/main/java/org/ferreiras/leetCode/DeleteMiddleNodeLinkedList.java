package org.ferreiras.leetCode;
/*
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

You are given the head of a linked list. Delete the middle node, and return the head
of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using
0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
For n = 1, 2, 3, 4, and 5, the middle node is 2, so return [1,2,4]
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Input: head = [1,2,3,4]
Output: [1,2,4]

 */



public class DeleteMiddleNodeLinkedList {
  static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  public ListNode deleteMiddle(ListNode head) {
    int len = 1;
    ListNode node = head;
    while (node != null) {
      node = node.next;
      len++;
    }
    int middle = len/2;


    System.out.println(len);
    return new ListNode();
  }
}
