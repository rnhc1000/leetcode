package org.ferreiras.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
There are n workers.
You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker
and wage[i] is the minimum wage expectation for the ith worker.

We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay
them according to the following rules:

Every worker in the paid group must be paid at least their minimum wage expectation.
In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s
quality is double that of another worker in the group, then they must be paid twice as much as the other
worker.
Given the integer k:
return the least amount of money needed to form a paid group satisfying the above conditions.
Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], k = 2
Output: 105.00000
Explanation:
We pay 70 to 0th worker and 35 to 2nd worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
Output: 30.66667
Explanation:
We pay 4 to 0th worker, 13.33333 to 2nd and 3rd workers separately.


Constraints:

n == quality.length == wage.length
1 <= k <= n <= 104
1 <= quality[i], wage[i] <= 104

Intuition by https://leetcode.com/suyalneeraj09
The intuition behind this approach is that the workers with the highest quality-to-wage ratio are
the most valuable. By considering these workers first, we can ensure that we are hiring the most
valuable workers and minimizing the cost. The priority queue helps in efficiently selecting the
top k workers with the highest qualities.

Approach
Sorting: First, the workers are sorted based on their quality-to-wage ratio.
This is done to ensure that the workers with the highest quality-to-wage ratio are considered first.
Priority Queue: A priority queue is used to keep track of the top k workers with the highest qualities.
The priority queue is ordered in descending order, so the worker with the highest quality is always at
the top.
Minimum Cost Calculation: The minimum cost is calculated by summing the qualities of the top k workers
and multiplying it by their average wage. This is done by iterating through the sorted workers and adding
their qualities to the total quality until the size of the priority queue reaches k.
Then, the total quality is updated by subtracting the quality of the worker that was removed from the
priority queue.
Return: The minimum cost is returned as the result.

Complexity
Time complexity: O(n log n)
Space complexity:O(n)
 */


public class ArrayMinimumCostHireWorkers {

  record Worker(int quality, int wage) {
  }

  public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {

    int size = quality.length;
    Worker[] workers = new Worker[size];

    for (int i = 0; i < size; i++) {
      workers[i] = new Worker(quality[i], wage[i]);
    }

    Arrays.sort(workers, (a, b) -> Double.compare((double) a.wage / a.quality, (double) b.wage / b.quality));
    System.out.println(Arrays.toString(workers));
    double minCost = Double.MAX_VALUE;
    int workQuality = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    for (Worker worker : workers) {
      workQuality += worker.quality;
      queue.offer(worker.quality);

      if (queue.size() > k) {
        workQuality -= queue.remove();
      }

      if (queue.size() == k) {
        double ratio = (double) worker.wage / worker.quality;
        minCost = Math.min(minCost, workQuality * ratio);
      }
    }

    return minCost;
  }

  public static void main(String[] args) {
    int[] quality = {10, 20, 5};
    int[] wage = {70, 50, 30};
    int kx = 2;
    double result = mincostToHireWorkers(quality, wage, kx);
    System.out.printf("%.4f", result);
  }
}

