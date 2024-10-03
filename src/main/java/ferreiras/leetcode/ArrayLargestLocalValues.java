package ferreiras.leetcode;

import java.util.Arrays;

/*
You are given an n x n integer matrix grid.
Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:

maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1
and column j + 1.
In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.

Return the generated matrix.

Example 1:
Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
Output: [[9,9],[8,6]]
Explanation: The diagram above shows the original matrix and the generated matrix.
Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3
matrix in grid.

Example 2:
Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
Output: [[2,2,2],[2,2,2],[2,2,2]]
Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.


Constraints:

n == grid.length == grid[i].length
3 <= n <= 100
1 <= grid[i][j] <= 100
 */
public class ArrayLargestLocalValues {
  public static int[][] largestLocal(int[][] grid) {

    int n = grid.length, m = grid[0].length;

    int[][] matrix = new int[n - 2][m - 2];

    for (int i = 1; i < n - 1; ++i) {

      for (int j = 1; j < m - 1; ++j) {

        int element = 0;

        for (int r = i - 1; r <= i + 1; ++r) {

          for (int s = j - 1; s <= j + 1; ++s) {

            element = Math.max(element, grid[r][s]);

          }
        }

        matrix[i - 1][j - 1] = element;
      }
    }

    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix = {
            {9, 9, 8, 1},
            {5, 6, 2, 6},
            {8, 2, 6, 4},
            {6, 2, 2, 2}
    };
    int[][] response = largestLocal(matrix);
    for (int[] r : response) {
      System.out.println(Arrays.toString(r));
    }
  }
}
