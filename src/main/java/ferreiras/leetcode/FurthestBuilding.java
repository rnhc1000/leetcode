package ferreiras.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * You are given an integer array heights representing the heights of buildings,
 * some bricks, and some ladders.
 * You start your journey from building 0 and move to the next building by possibly
 * using bricks or ladders.
 * While moving from building i to building i+1 (0-indexed),
 * If the current building's height is greater than or equal to the next building's height,
 * you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either
 * use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders
 * and bricks optimally.
 * Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * Output: 4
 * Explanation: Starting at building 0, you can follow these steps:
 * - Go to building 1 without using ladders nor bricks since 4 >= 2.
 * - Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
 * - Go to building 3 without using ladders nor bricks since 7 >= 6.
 * - Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
 * It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 * Example 2:
 * Input: heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
 * Output: 7
 * Example 3:
 * Input: heights = [14,3,19,3], bricks = 17, ladders = 0
 * Output: 3
 * * Intuition based on
 * <a href="https://leetcode.com/Mohammed_Raziullah_Ansari/">...</a>
 * Approach
 * Initialize an empty Priority Queue pq to store the differences in heights between
 * consecutive buildings.
 * Iterate through each building in the list of heights.
 * Calculate the difference diff between the current building's height and the next
 * building's height.
 * If the diff is positive, it means that we need to climb some steps.
 * In this case, add the diff to the Priority Queue pq.
 * If the Priority Queue pq has more elements than the ladders, it means that we have
 * used all the ladders available. In this case, we need to use bricks to climb. Subtract
 * the top element from the Priority Queue pq and subtract it from bricks.
 * If the bricks become negative, it means we cannot proceed further and return
 * the current index i.
 * Finally, if the above conditions don't apply, we continue iterating through the buildings.
 * Return the index i if the loop exits without breaking.
 * Complexity
 * ⏱️ Time complexity: O(n*log(k))
 * 🚀 Space complexity: O(n+k)
 */
public class FurthestBuilding {
  public static void main(String[] args) {

    int[] buildings = {4, 2, 7, 6, 9, 14, 12};
    int bricks = 5, ladders = 1;
    int response = furthestBuilding(buildings, bricks, ladders);
    System.out.println(response);
  }

  public int farthestBuilding(int[] heights, int bricks, int ladders) {
    Queue<Integer> heap = new PriorityQueue<>();
    for (int i = 0; i < heights.length - 1; i++) {
      int diff = heights[i + 1] - heights[i];
      if (diff > 0) {
        heap.offer(diff);
        if (heap.size() > ladders) {
          bricks -= heap.poll();
        }
        if (bricks < 0) {
          return i;
        }
      }
    }
    return heights.length - 1;
  }

  public static int furthestBuilding(int[] heights, int bricks, int ladders) {
    /**
     *  * If the current building's height is greater than or equal to the next building's height,
     *  * you do not need a ladder or bricks.
     *  * If the current building's height is less than the next building's height, you can either
     *  * use one ladder or (h[i+1] - h[i]) bricks.
     */

    Queue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
    int building = 0, next = 0;
    for (; building < heights.length - 1; building++) {
      next = heights[building + 1] - heights[building];
      if (next <= 0)
        continue;
      bricks = bricks - next;
      queue.offer(next);
      if (bricks < 0) {
        bricks = bricks + queue.poll();
        ladders--;
      }
      if (ladders < 0) {
        break;
      }
    }
    return building;
  }
}
