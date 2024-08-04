package org.ferreiras.leetCode;

import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
 * You are also given two integers k and candidates. We want to hire exactly k workers according to
 * the following rules:
 * You will run k sessions and hire exactly one worker in each session.
 * In each hiring session, choose the worker with the lowest cost from either the first candidates
 * workers or the last candidates workers. Break the tie by the smallest index.
 * For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will
 * choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
 * In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th
 * worker but they have the smallest index [3,2,7,7,2].
 * Please note that the indexing may be changed in the process.
 * If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them.
 * Break the tie by the smallest index.
 * A worker can only be chosen once.
 * Return the total cost to hire exactly k workers.
 * Example 1:
 * Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * Output: 11
 * Explanation: We hire 3 workers in total. The total cost is initially 0.
 * - In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8].
 * The lowest cost is 2, and we break the tie by the smallest index, which is 3.
 * The total cost = 0 + 2 = 2.
 * - In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8].
 * The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
 * - In the third hiring round we choose the worker from [17,12,10,7,11,20,8].
 * The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was
 * common in the first and last four workers.
 * The total hiring cost is 11.
 * Example 2:
 * Input: costs = [1,2,4,1], k = 3, candidates = 3
 * Output: 4
 * Explanation: We hire 3 workers in total. The total cost is initially 0.
 * - In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break
 * the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1.
 * Notice that workers with index 1 and 2 are common in the first and last 3 workers.
 * - In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2).
 * The total cost = 1 + 1 = 2.
 * - In the third hiring round there are less than three candidates. We choose the worker from the
 * remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
 * The total hiring cost is 4.
 * Intuition:
 * To Intuition is to maintains two priority queues (pq1 and pq2) that store the candidates smallest
 * costs from the beginning and end of the list.
 * In each iteration, the code compares the smallest costs from pq1 and pq2 and selects the one with
 * the lowest value. The corresponding cost is added to the total cost (ans), and the element is removed
 * from the respective priority queue.
 * This process continues for k iterations, and at the end, the accumulated ans value represents the
 * minimum total cost required to hire k workers.
 * Explanation:
 * Two integer variables i and j are initialized to track the start and end indices of the costs vector,
 * respectively. These indices will be used to iterate over the vector.
 * Two priority queues, pq1 and pq2, are created. Priority queues are data structures that allow efficient
 * insertion and retrieval of elements while maintaining a specific order.
 * In this case, the elements are integers, and the order is ascending (greater<int>).
 * A long variable ans is initialized to store the total cost.
 * The code enters a loop that executes k times, where k is the number of workers to be hired.
 * Inside the loop, two nested while loops are used to populate pq1 and pq2 with candidates from the costs
 * vector. The conditions for these loops are as follows:
 * pq1 should contain at most candidates elements, and i should be less than or equal to j.
 * pq2 should also contain at most candidates elements, and i should be less than or equal to j.
 * These loops essentially fill the priority queues with the smallest candidates elements from the costs
 * vector, taking elements from both ends of the vector (i and j).
 * After the while loops, the code compares the top elements (t1 and t2) of pq1 and pq2 to determine which
 * one is smaller. If both queues are empty, INT_MAX (maximum value for an int) is used as a placeholder.
 * If t1 is smaller than or equal to t2, the cost of the worker represented by t1 is added to ans, and the
 * top element is removed from pq1 using pq1.pop(). Otherwise, the cost of the worker represented by t2 is
 * added to ans, and the top element is removed from pq2 using pq2.pop().
 * The loop continues until k workers have been hired.
 * Finally, the function returns the accumulated total cost (ans).
 */
public class CostHireWorkers {

  public static void main(String[] args) {
    int[] costs = {17, 12, 10, 2, 7, 2, 11, 20, 8};
    int k = 3;
    int candidates = 4;
    long response = totalCost(costs, k, candidates);
    System.out.println(response);
  }

  public static long totalCost(int[] costs, int k, int candidates) {
    int left = 0;
    int right = costs.length - 1;
    long response = 0;

    PriorityQueue<Integer> pqOne = new PriorityQueue<>();
    PriorityQueue<Integer> pqTwo = new PriorityQueue<>();

    while (k-- > 0) {
      while (pqOne.size() < candidates && left <= right) {
        pqOne.offer(costs[left++]);
      }
      while (pqTwo.size() < candidates && left <= right) {
        pqTwo.offer(costs[right--]);
      }

      int totalOne = !pqOne.isEmpty() ? pqOne.peek() : Integer.MAX_VALUE;
      int totalTwo = !pqTwo.isEmpty() ? pqTwo.peek() : Integer.MAX_VALUE;

      if (totalOne <= totalTwo) {
        response += totalOne;
        pqOne.poll();
      } else {
        response += totalTwo;
        pqTwo.poll();
      }
    }
    return response;
  }

  public static long totalCosts(int[] costs, int k, int candidates) {
    int l = 0, r = costs.length - 1;

    PriorityQueue<int[]> L = new PriorityQueue<>(r + 1, (int[] o1, int[] o2) -> {
      if (o2[0] != o1[0])
        return o1[0] - o2[0];
      return o1[1] - o2[1];
    });
    PriorityQueue<int[]> R = new PriorityQueue<>(r + 1, (int[] o1, int[] o2) -> {
      if (o2[0] != o1[0])
        return o1[0] - o2[0];
      return o1[1] - o2[1];
    });

    long ans = 0;

    while (k-- != 0) {
      while (l <= r && L.size() < candidates) {
        L.add(new int[]{costs[l], l});
        l++;
      }
      while (l <= r && R.size() < candidates) {
        R.add(new int[]{costs[r], r});
        r--;
      }

      if (L.isEmpty())
        ans += R.poll()[0];
      else if (R.isEmpty())
        ans += L.poll()[0];
      else if (L.peek()[0] <= R.peek()[0])
        ans += L.poll()[0];
      else
        ans += R.poll()[0];
    }
    return ans;
  }
}
