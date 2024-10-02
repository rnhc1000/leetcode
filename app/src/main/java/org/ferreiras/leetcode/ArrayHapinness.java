package org.ferreiras.leetcode;

import java.util.*;

/*
You are given an array happiness of length n, and a positive integer k.

There are n children standing in a queue, where the ith child has happiness value happiness[i].
You want to select k children from these n children in k turns.

In each turn, when you select a child, the happiness value of all the children that have not been
selected till now decreases by 1. Note that the happiness value cannot become negative and gets
decremented only if it is positive.

Return the maximum sum of the happiness values of the selected children you can achieve by selecting
k children.

Example 1:

Input: happiness = [1,2,3], k = 2
Output: 4
Explanation: We can pick 2 children in the following way:
- Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
- Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
The sum of the happiness values of the selected children is 3 + 1 = 4.
Example 2:

Input: happiness = [1,1,1,1], k = 2
Output: 1
Explanation: We can pick 2 children in the following way:
- Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
- Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
The sum of the happiness values of the selected children is 1 + 0 = 1.
Example 3:

Input: happiness = [2,3,4,5], k = 1
Output: 5
Explanation: We can pick 1 child in the following way:
- Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
The sum of the happiness values of the selected children is 5.


Constraints:

1 <= n == happiness.length <= 2 * 105
1 <= happiness[i] <= 108
1 <= k <= n

Detailed Approach:
Convert the List to a Max Heap: To efficiently select the children with the highest happiness values,
we can use a max heap. However, Python's default heap implementation is a min heap. So, we convert
the list into a max heap by inverting the happiness values (multiply each value by -1).

Initialize Variables:
Initialize total_happiness_sum to keep track of the sum of happiness values of the selected children.
Initialize turns to keep track of the number of turns taken.

Iterate for K Turns: We iterate for k turns, where in each turn, we:

Pop the top element from the max heap. Since we inverted the happiness values initially, popping from
the heap gives us the child with the highest original happiness value.
Decrement the happiness value by the number of turns taken so far.
This accounts for the decrement in happiness for all unselected children.
Add the happiness value to total_happiness_sum.
Ensure that negative happiness values are not considered by taking the maximum of 0 and the computed value.
Increment the turns variable to prepare for the next iteration.
Return Total Happiness Sum: After k turns, return the total happiness sum, which represents the maximum
sum of happiness values achievable by selecting k children.


 */
public class ArrayHapinness {
  public static void main(String[] args) {
    int[] happy = {1, 2, 3};
    int k = 2;
    long response = maxHappinessSum(happy, k);
    System.out.println(response);
  }

  public static long maximumHappinessSum(int[] happiness, int k) {

    int size = happiness.length - 1;
    Arrays.sort(happiness);
    List<Integer> list = new ArrayList<>();
    list.add(happiness[size]);
    k--;
    while (k > 0) {
      list.add(happiness[--size] - 1);
//      size--;
      k--;
    }
    int sum = 0;
    for (int s : list) {
      sum += s;
    }
    return sum;
  }

  public static long maxHappinessSum(int[] happiness, int k) {
    Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    long totalHappiness = 0L;
    int turns = 0;
    for (int happy : happiness) {
      queue.add(happy);
    }
    System.out.println(queue);

    for (int i = 0; i < k; i++) {
      if (!queue.isEmpty()) {
        totalHappiness += Math.max(queue.poll() - turns, 0);
        turns++;

      }
    }
    return totalHappiness;
  }
}
