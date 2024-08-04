package org.ferreiras.leetCode;

import java.util.*;
import java.util.stream.IntStream;

/*
Given two integer arrays pushed and popped each with distinct values,
return true if this could have been the result of a sequence of push and pop
operations on an initially empty stack, or false otherwise.


Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.


Constraints:

1 <= pushed.length <= 1000
0 <= pushed[i] <= 1000
All the elements of pushed are unique.
popped.length == pushed.length
popped is a permutation of pushed.
 */
public class StackSequence {
  public static void main(String[] args) {

    int[] pushed = {1, 2, 3, 4, 5};
    int[] popped = {4, 5, 3, 2, 1};
    boolean response = validateStackSequences(pushed, popped);
    System.out.println(response);
  }

  public static boolean validateStackSequences(int[] pushed, int[] popped) {
    Deque<Integer> queue = new ArrayDeque<>();
    if (pushed.length != popped.length) return false;
    int track = 0;
    for (int i = 0; i < pushed.length; i++) {
      queue.push(pushed[i]);
      while (!queue.isEmpty() && track != popped.length) {
        if (queue.peek() == popped[track]) {
          queue.pop();
          track++;
        } else {
          break;
        }
      }
    }
    System.out.println(queue);
    return queue.isEmpty();
  }
}
