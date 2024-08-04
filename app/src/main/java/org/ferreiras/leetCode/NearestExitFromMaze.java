package org.ferreiras.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.')
 * and walls (represented as '+'). You are also given the entrance of the maze, where
 * entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are
 * initially standing at.
 * In one step, you can move one cell up, down, left, or right. You cannot step into a
 * cell with a wall, and you cannot step outside the maze. Your goal is to find the
 * nearest exit from the entrance. An exit is defined as an empty cell that is at the
 * border of the maze. The entrance does not count as an exit.
 * Return the number of steps in the shortest path from the entrance to the nearest exit,
 * or -1 if no such path exists.
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * Output: 1
 * Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
 * Initially, you are at the entrance cell [1,2].
 * - You can reach [1,0] by moving 2 steps left.
 * - You can reach [0,2] by moving 1 step up.
 * It is impossible to reach [2,3] from the entrance.
 * Thus, the nearest exit is [0,2], which is 1 step away.
 */
public class NearestExitFromMaze {
  static class Triple {
    int first;
    int second;
    int step;

    Triple (int fst, int scnd, int step) {
      this.first = fst;
      this.second = scnd;
      this.step = step;
    }
  }

  public int nearestExit(char[][] maze, int[] entrance) {
    int n = maze.length;
    int m = maze[0].length;

    int x = entrance[0];
    int y = entrance[1];

    int[] delRow = {1, -1, 0, 0};
    int[] delCol = {0, 0, 1, -1};

    int response = 0;

    Queue<Triple> queue = new LinkedList<Triple >();
    queue.add(new Triple (x, y, 0));

    while (!queue.isEmpty()) {
      int row = queue.peek().first;
      int col = queue.peek().second;
      int step = queue.peek().step;
      maze[row][col] = '+';
      queue.poll();

      for (int i = 0; i < 4; i++) {
        int rows = row + delRow[i];
        int cols = col + delCol[i];

        if (rows >= 0 && rows < n && cols >= 0 && cols < m && maze[rows][cols] == '.') {
          maze[rows][cols] = '+';
          queue.add(new Triple (rows, cols, step + 1));
          if (rows == 0 || cols == 0 || rows == n - 1 || cols == m - 1) {
            response = step + 1;
            return response;
          }
        }
      }
    }
    return -1;
  }
}

