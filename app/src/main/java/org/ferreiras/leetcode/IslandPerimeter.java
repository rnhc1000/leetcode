package org.ferreiras.leetcode;

/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and
grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally).
The grid is completely surrounded by water, and there is exactly one island
(i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water
around the island. One cell is a square with side length 1.
The grid is rectangular, width and height don't exceed 100.
Determine the perimeter of the island.

Example 1:
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation:
The perimeter is the 16 yellow stripes in the image above.

Example 2:
Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4


Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
There is exactly one island in grid.

Begin at the top-left corner of the grid.
Look at each cell one by one.
Checking Each Cell:
For each cell that contains land:
Check if any of its neighboring cells are water or if the cell is at the edge of the grid.
If a neighbor is water or the cell is at the grid edge, add to the perimeter count.
Moving to Next Cell:
Move to the cell on the right.
Repeat the process for each cell in the row.
Once a row is complete, move to the next row and repeat until all cells are checked.
Calculating Perimeter:
Sum up all the counts from step 2 for each land cell.
The total count represents the perimeter of the land in the grid.
 */
/*
 * @param {{integer}} distribution
 * @return {int}
 */
public class IslandPerimeter {
  public static void main(String[] args) {
    int[][] distribution = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
    };
    int perimeter = islandPerimeter(distribution);
    System.out.println(perimeter);
  }

  public static int islandPerimeter(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int perimeter = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          if ((j > 0 && grid[i][j - 1] == 0) || j == 0)
            perimeter++;

          if ((i > 0 && grid[i - 1][j] == 0) || i == 0)
            perimeter++;

          if ((j < n - 1 && grid[i][j + 1] == 0) || j == n - 1)
            perimeter++;

          if ((i < m - 1 && grid[i + 1][j] == 0) || i == m - 1)
            perimeter++;
        }
      }
    }

    return perimeter;
  }
}
