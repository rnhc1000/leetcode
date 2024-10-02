package org.ferreiras.leetcode;

import java.util.Arrays;

/*
You start at the cell (rStart, cStart) of an rows x cols grid facing east.
The northwest corner is at the first row and column in the grid, and the southeast corner is at the
last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's
boundary, we continue our walk outside the grid (but may return to the grid boundary later.).
Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.



Example 1:


Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]
Example 2:


Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],
[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]


Constraints:

1 <= rows, cols <= 100
0 <= rStart < rows
0 <= cStart < cols
Intuition by https://leetcode.com/kartikdevsharmaa
We're dealing with a 2D grid and a pattern of movement that spirals outward from a given starting point.
The key insight here is recognizing the regularity in this spiral pattern.

When we visualize a spiral, we can see that it consists of a series of "arms" that extend in four directions:
right, down, left, and up. Each complete rotation of the spiral increases the length of these arms.
This observation forms the foundation of our approach.

Another crucial insight is that even though we're spiraling outwards, we're only interested in the cells that
fall within our defined grid. This means we need a way to track our position and only record valid coordinates.

Lastly, we need to consider how to efficiently generate this spiral pattern.
The regularity of the pattern suggests that we could use a systematic approach,
possibly involving direction changes and step counts.

Approach
1. Direction Management
To manage the spiral's direction, we use a 2D array to represent the four possible movements:

int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
These correspond to moving right, down, left, and up respectively.
By cycling through these directions, we can create our spiral pattern.

We use a variable d to keep track of our current direction:

int d = 0;
After each arm of the spiral, we update our direction:

d = (d + 1) % 4;
This clever use of modulo arithmetic ensures that we cycle through our directions array continuously.

2. Step Size Control
A key characteristic of a spiral is that it extends further with each rotation.
We manage this with a moves variable:

int moves = 0;
We increment moves after moving east (d = 0) or west (d = 2):

if (d == 0 || d == 2) moves++;
This ensures that our spiral arms grow longer as we progress.

3. Grid Traversal
To traverse the grid, we use our current position (rStart, cStart) and update it based on our current
direction and step size:

for (int i = 0; i < moves; i++) {
    rStart += directions[d][0];
    cStart += directions[d][1];
    // ... (boundary checking and result collection here)
}
This loop moves us along one arm of the spiral.

4. Boundary Checking
Not all positions in our spiral will be within the grid boundaries. We check each new position:

if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
    // ... (result collection here)
}
This ensures we only consider valid grid positions.

5. Result Collection
We collect our results in a 2D array:

int[][] result = new int[rows * cols][2];
Each valid position is added to this array:

result[count++] = new int[]{rStart, cStart};
We use a count variable to keep track of how many positions we've added, and to determine when we've
filled our result array.

Final Step
The entire process is wrapped in a while loop that continues until we've collected all the positions in our grid:

while (count < rows * cols) {
    // ... (direction management, step size control, grid traversal,
    //      boundary checking, and result collection here)
}
Complexity Analysis
Time Complexity: O(max(R, C)^2)
The time complexity of this algorithm is O(max(R, C)^2), where R is the number of rows and C is the number of
columns in the grid.

To understand this, let's break it down:

The spiral pattern we generate is essentially a square with side length max(R, C) * 2.
This is because in the worst case, we need to spiral out far enough to reach the farthest corner of our grid.

The total number of cells in this larger square is (max(R, C) * 2)^2 = 4 * max(R, C)^2.

Our algorithm visits each of these cells exactly once, even though we only record the ones that fall within
our actual grid.

Therefore, the number of iterations our algorithm performs is proportional to max(R, C)^2.

Even though we're only interested in R * C cells, our algorithm may need to visit up to 4 * max(R, C)^2 positions
to ensure we've covered all the cells in our grid. This is why the time complexity is quadratic in terms of the
larger dimension of the grid.

Space Complexity
The space complexity of this algorithm is O(R * C), where R is the number of rows and C is the number of
columns in the grid.

This space requirement comes from our result array:

int[][] result = new int[rows * cols][2];
We're storing exactly R * C positions, each represented by a pair of integers.

This space complexity is optimal for this problem, as we need to return all the positions in the grid. We couldn't
solve this problem with less space, as the output itself requires O(R * C) space.

Additional space used by our algorithm (for variables like moves, d, rStart, cStart, etc.) is constant and doesn't
grow with the size of the input, so it doesn't affect our space complexity analysis.
 */
public class ArraySpiralTwo {

  public static void main(String[] args) {
    int rows = 5, cols = 6, rStart = 1, cStart = 4;
    int[][] responses = spiralMatrixIII(rows, cols, rStart, cStart);
    for (int[] response : responses) {
      System.out.println(Arrays.toString(response));
    }
  }

  public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // East, South, West, North
    int[][] result = new int[rows * cols][2];
    int moves = 0, d = 0, len = 0;

    result[0] = new int[]{rStart, cStart};
    int count = 1;

    while (count < rows * cols) {
      if (d == 0 || d == 2) moves++; // Increase step size after moving East or West

      for (int i = 0; i < moves; i++) {
        rStart += directions[d][0];
        cStart += directions[d][1];

        if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
          result[count++] = new int[]{rStart, cStart};
        }

        if (count == rows * cols) return result;
      }

      d = (d + 1) % 4; // Change direction
    }

    return result;
  }

}
