package ferreiras.leetcode;

/*
You are given a rows x cols matrix grid representing a field of cherries
where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of cherries collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.


Example 1:


Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
Total of cherries: 12 + 12 = 24.
Example 2:


Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
Output: 28
Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
Total of cherries: 17 + 11 = 28.


Constraints:

rows == grid.length
cols == grid[i].length
2 <= rows, cols <= 70
0 <= grid[i][j] <= 100
Accepted
176,257
Submissions
24

Intuition by https://leetcode.com/Shivansu_7

Tips
No cells have negative value.
If both robot collied, then the value of the cell will be counted once.
condition for collision (col1==col2).

Approach
Initialization:
Initialize variables n and m representing the number of rows and columns in the grid, respectively.
Create a 3D array dp of size [n][m][m] to memoize the results of subproblems. dp[r][col1][col2] will store the maximum number of cherries that can be picked starting from row r, with one picker at column col1 and the other picker at column col2.
Depth-First Search (DFS) function:
The DFS function dfs takes the grid, dimensions n and m, current row r, columns of both pickers col1 and col2, and the memoization array dp.
Base case: If either picker goes out of bounds, return 0 (no cherries picked).
Memoization: If the result for the current state (dp[r][col1][col2]) is already computed, return it.
Explore all possible movements for both pickers (up, left, right):
Recur for the next row and updated column positions.
Update maxCherries with the maximum cherries collected among all movements.
Calculate the cherries collected in the current cell (currCherry), considering if both pickers are in the same column or different columns.
Store the result in dp[r][col1][col2] and return it.
Cherry Picking:
Start DFS from the top row (r = 0) with both pickers at the outermost columns (col1 = 0, col2 = m-1).
The result of the DFS call will be the maximum cherries picked from the grid.
Complexity
Time complexity: $$O(nmm)$$
Space complexity: $$O(nmm)$$
 */
public class ArrayCherryPickTwo {

  public static void main(String[] args) {

    int[][] grid = {
            {3, 1, 1},
            {2, 5, 1},
            {1, 5, 5},
            {2, 1, 1}
    };
    int response = cherryPickup(grid);
    System.out.println(response);
  }

  public static int cherryPickup(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    int[][][] dp = new int[n][][];
    for (int i = 0; i < n; i++) {
      dp[i] = new int[m][];
      for (int j = 0; j < m; j++) {
        dp[i][j] = new int[m];
        for (int k = 0; k < m; k++) {
          dp[i][j][k] = -1;
        }
      }
    }

    return DFS(grid, n, m, 0, 0, m - 1, dp);
  }

  private static int DFS(int[][] grid, int n, int m, int r, int robotOne, int robotTwo, int[][][] dp) {
    if (r < 0 || r >= n || robotOne < 0 || robotOne >= m || robotTwo < 0 || robotTwo >= m) {
      return 0;
    }

    if (dp[r][robotOne][robotTwo] != -1) {
      return dp[r][robotOne][robotTwo];
    }

    int maxCherries = 0;

    for (int i = -1; i <= 1; i++) {
      for (int j = -1; j <= 1; j++) {
        int newCol1 = robotOne + i;
        int newCol2 = robotTwo + j;
        maxCherries = Math.max(maxCherries, DFS(grid, n, m, r + 1, newCol1, newCol2, dp));
      }
    }

    int currCherry = (robotOne == robotTwo) ? grid[r][robotOne] : grid[r][robotOne] + grid[r][robotTwo];

    dp[r][robotOne][robotTwo] = currCherry + maxCherries;


    return dp[r][robotOne][robotTwo];
  }
}
