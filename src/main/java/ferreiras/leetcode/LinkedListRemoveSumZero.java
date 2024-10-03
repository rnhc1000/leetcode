package ferreiras.leetcode;
/*
Given the head of a linked list, we repeatedly delete consecutive sequences of nodes
that sum to 0 until there are no such sequences.
After doing so, return the head of the final linked list.
You may return any such answer.

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]


Constraints:

The given linked list will contain between 1 and 1000 nodes.
Each node in the linked list has -1000 <= node.val <= 1000.
Intuition
The intuition behind this approach is to use the concept of prefix sum combined with a hash map.
A prefix sum here represents the cumulative sum of the nodes from the start up to the current node.
By storing these prefix sums and their corresponding nodes in a hash map, we can easily identify
parts of the list that sum up to zero.
When we encounter a prefix sum that we've seen before, it indicates that the sum of the nodes
between the previous occurrence and the current node is zero, and those nodes can be removed.
 */
import java.util.HashMap;
import java.util.Map;

public class LinkedListRemoveSumZero {
  public static ListNode removeZeroSumSublists(ListNode head) {
    int prefixSum = 0;
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    map.put(0, dummy);
    while (head != null) {
      prefixSum += head.val;
      if (map.containsKey(prefixSum)) {
        ListNode start = map.get(prefixSum);
        ListNode temp = start;
        int sum = prefixSum;
        while (temp != head) {
          temp = temp.next;
          sum += temp.val;
          if (temp != head) map.remove(sum);
        }
        start.next = head.next;
      } else {
        map.put(prefixSum, head);
      }
      head = head.next;
    }

    return dummy.next;
  }
  public static ListNode removeZeroSumSublist(ListNode head) {
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;
    int sum = 0;

    Map<Integer, ListNode> map = new HashMap<>();
    map.put(0, dummyNode);

    for (ListNode node = dummyNode; node != null; node = node.next) {
      sum += node.val;
      map.put(sum, node);
    }

    sum = 0;

    for (ListNode node = dummyNode; node != null; node = node.next) {
      sum += node.val;
      node.next = map.get(sum).next;
    }

    return dummyNode.next;
  }
  int test() {
    System.out.println();
    return 0;
  }
}
