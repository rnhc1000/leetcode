package org.ferreiras.leetCode;
/*
Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such
that no two elements chosen in adjacent rows are in the same column.

Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation:
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.

Example 2:
Input: grid = [[7]]
Output: 7

Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
-99 <= grid[i][j] <= 99
 */
public class MinimumFallingPathSum {
  public static void main(String[] args) {
    int[][] falling = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };
    int response = minFallingPathSum(falling);
    System.out.println(response);
  }
  public static int minFallingPathSum(int[][] grid) {
    int size = grid.length;

    for (int i = 1; i < size; i++) {
      for (int j = 0; j < size; j++) {
        int best = Integer.MAX_VALUE;
        for (int k = 0; k < size; k++) {
          if (k != j) {
            best = Math.min(best, grid[i - 1][k]);
          }
        }
        grid[i][j] += best;
      }
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < size; i++) {
      result = Math.min(result, grid[size - 1][i]);
    }

    return result;
  }

}
