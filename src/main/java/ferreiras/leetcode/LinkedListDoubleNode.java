package ferreiras.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given the head of a non-empty linked list representing a non-negative integer
without leading zeroes.

Return the head of the linked list after doubling it.

Example 1:


Input: head = [1,8,9]
Output: [3,7,8]
Explanation:
The figure above corresponds to the given linked list which represents the number 189.
Hence, the returned linked list represents the number 189 * 2 = 378.

Example 2:
Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation:
The figure above corresponds to the given linked list which represents the number 999.
Hence, the returned linked list represents the number 999 * 2 = 1998.

Constraints:

The number of nodes in the list is in the range [1, 104]
0 <= Node.val <= 9
The input is generated such that the list represents a number that does not have leading zeros,
except the number 0 itself.
Intuition by https://leetcode.com/Mohammed_Raziullah_Ansari
This approach utilizes a stack to store the values of the linked list in reverse order, allowing us to process the digits from least significant to most significant. After storing the values, it iterates over them while maintaining a carry, doubling each digit and updating the carry as necessary. It then constructs a new linked list by creating nodes with the calculated values, effectively doubling the original number represented by the linked list.

Detailed Approach:
Initialize Stack and Variables:
Begin by initializing an empty stack (stack) to store the values of the linked list in reverse order.
Also, initialize a variable val to track the carryover during doubling.

Traverse Linked List and Push Values onto Stack:
Traverse the original linked list, pushing each node's value onto the stack.
This step effectively reverses the order of the values in the linked list.

Initialize New Tail Pointer:
Initialize a pointer new_tail to None, which will be used to construct the new linked list.

Process Values and Carryover:

Iterate over the stack (values) and the carryover (val).
Inside the loop, create a new ListNode with value 0 and the previous tail (new_tail) as its next node.
This step effectively builds the new linked list in reverse order.
Calculate the new value for the current node by doubling the last digit, adding the carry (val), and
getting the remainder after division by 10. Update val accordingly for the next iteration.
If there are no more values in the stack but there's still a carryover, continue processing it until it
becomes zero.
Return New Tail of Linked List: Once all nodes are processed and the carryover is resolved, return the
new_tail, which represents the head of the newly constructed linked list.
 */
public class LinkedListDoubleNode {
  public static ListNode doubleIt(ListNode head) {

    Deque<Integer> stack = new ArrayDeque<>();
    int val = 0;

    while (head != null) {
      stack.push(head.val);
      head = head.next;
    }

    ListNode newTail = null;

    while (!stack.isEmpty() || val != 0) {

      newTail = new ListNode(0, newTail);


      if (!stack.isEmpty()) {
        val += stack.pop() * 2;
      }
      newTail.val = val % 10;
      val /= 10;
    }

    return newTail;
  }

  public static ListNode doubleValue(ListNode head) {

    ListNode reversedList = reverseList(head);
    // Initialize variables to track carry and previous node
    int carry = 0;
    ListNode current = reversedList, previous = null;

    // Traverse the reversed linked list
    while (current != null) {
      // Calculate the new value for the current node
      int newValue = current.val * 2 + carry;
      // Update the current node's value
      current.val = newValue % 10;
      // Update carry for the next iteration
      if (newValue > 9) {
        carry = 1;
      } else {
        carry = 0;
      }
      // Move to the next node
      previous = current;
      current = current.next;
    }

    // If there's a carry after the loop, add an extra node
    if (carry != 0) {
      ListNode extraNode = new ListNode(carry);
      previous.next = extraNode;
    }

    // Reverse the list again to get the original order
    ListNode result = reverseList(reversedList);

    return result;
  }

  // Method to reverse the linked list
  public static ListNode reverseList(ListNode node) {
    ListNode previous = null, current = node, nextNode;

    // Traverse the original linked list
    while (current != null) {
      // Store the next node
      nextNode = current.next;
      // Reverse the link
      current.next = previous;
      // Move to the next nodes
      previous = current;
      current = nextNode;
    }
    // Previous becomes the new head of the reversed list
    return previous;
  }
}
