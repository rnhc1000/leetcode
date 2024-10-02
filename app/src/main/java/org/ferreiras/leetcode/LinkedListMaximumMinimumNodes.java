package org.ferreiras.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is
the minimum distance between any two distinct critical points and maxDistance is the maxima distance between any
two distinct critical points. If there are fewer than two critical points, return [-1, -1].



Example 1:


Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].
Example 2:


Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
Example 3:


Input: head = [1,3,2,2,3,2,2,2,7]
Output: [3,3]
Explanation: There are two critical points:
- [1,3,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
- [1,3,2,2,3,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
Both the minimum and maximum distances are between the second and the fifth node.
Thus, minDistance and maxDistance is 5 - 2 = 3.
Note that the last node is not considered a local maxima because it does not have a next node.


Constraints:

The number of nodes in the list is in the range [2, 105].
1 <= Node.val <= 105

Intuition by https://leetcode.com/Yash_L
1. Traverse the Linked List:
Purpose: Identify critical points, which are either local minima or local maxima.
Details: Iterate through the linked list while maintaining a pointer for the previous node and the current node. This allows comparison between the previous, current, and next node values to determine if the current node is a critical point.

2. Record Positions of Critical Points:
Purpose: Store the positions (indices) of the critical points for distance calculations.
Details: As you traverse the list, if a node is determined to be a critical point, store its position in an array or list.

3. Calculate Distance
Purpose: Determine the minimum and maximum distances between the identified critical points.
Details:
If fewer than two critical points are identified, return [-1, -1] immediately.
Otherwise, compute the minimum distance between consecutive critical points and the maximum distance between the first and last critical points in the list.

4. Return the Results:
Purpose: Provide the final result in the required format.
Details: Return an array containing the minimum and maximum distances.
 */
public class LinkedListMaximumMinimumNodes {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return new int[]{-1, -1};
    }

    List<Integer> criticalPoints = new LinkedList<>();
    ListNode previous = head, current = head.next;
    int index = 1;

    while (current.next != null) {
      if ((current.val > previous.val && current.val > current.next.val) ||
              (current.val < previous.val && current.val < current.next.val)) {
        criticalPoints.add(index);
      }
      previous = current;
      current = current.next;
      index++;
    }

    if (criticalPoints.size() < 2) {
      return new int[]{-1, -1};
    }

    int minima = Integer.MAX_VALUE;
    int maxima = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);

    for (int i = 1; i < criticalPoints.size(); i++) {
      minima = Math.min(minima, criticalPoints.get(i) - criticalPoints.get(i - 1));
    }

    return new int[]{minima, maxima};
  }
}
