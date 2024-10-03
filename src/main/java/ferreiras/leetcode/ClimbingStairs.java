package ferreiras.leetcode;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step
 * on a staircase. Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 */
public class ClimbingStairs {
  public static void main(String[] args) {
    int[] cost = {1,100,1,1,1,100,1,1,100,1};
    int response = minCostClimbingStairs(cost);
    System.out.println(response);
  }

  public static int minCostClimbingStairs(int[] cost) {
    int steps = cost.length;
    int[] costs = new int[steps];
    for (int i=0; i<steps; i++) {
      if (i<2) costs[i] = cost[i];
      else costs[i] = cost[i] + Math.min(costs[i-1], costs[i-2]);
    }
    return Math.min(costs[steps-1], costs[steps-2]);
  }
  public static int minCostClimbingStairss(int[] cost) {
    int n = cost.length;
    return Math.min(minCost(cost, n-1), minCost(cost, n-2));
  }
  private static int minCost(int[] cost, int n) {
    if (n < 0) return 0;
    if (n==0 || n==1) return cost[n];
    return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));
  }


}
