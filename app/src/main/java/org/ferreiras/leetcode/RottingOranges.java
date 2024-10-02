package org.ferreiras.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange
 * becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 */
public class RottingOranges {

  public static void main(String[] args) {
    int[][] oranges = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
    };
    int response = orangesRotting(oranges);
    System.out.println(response);
  }
  static class Position {
    int x;
    int y;
    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public static int orangesRotting(int[][] grid) {
    Queue<Position> q = new LinkedList<>();
    int totalOranges = 0, rotten = 0, time = 0;

    // traverse the grid, offer position of rotten orange into queue, and count the
    // totalOranges num of orange
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 || grid[i][j] == 2)
          totalOranges++;
        if (grid[i][j] == 2)
          q.offer(new Position(i, j));
      }
    }

    // if there is no orange, return 0;
    if (totalOranges == 0)
      return 0;

    while (!q.isEmpty() && rotten < totalOranges) {
      // size is the num of rotten oranges of the last round
      int size = q.size();

      // count the num of rotten oranges, if it equals to totalOranges num, return time;
      rotten += size;
      if (rotten == totalOranges)
        return time;

      // every round, time ++
      time++;

      // Continue to dequeue until all rotten oranges of last round are removed from
      // the queue
      for (int i = 0; i < size; i++) {
        Position p = q.peek();

        // check the cell in the left/right/top/down of the rotten orange, if it is a
        // fresh orange, enqueue it.
        if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
          grid[p.x + 1][p.y] = 2;
          q.offer(new Position(p.x + 1, p.y));
        }
        if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
          grid[p.x - 1][p.y] = 2;
          q.offer(new Position(p.x - 1, p.y));
        }
        if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
          grid[p.x][p.y + 1] = 2;
          q.offer(new Position(p.x, p.y + 1));
        }
        if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
          grid[p.x][p.y - 1] = 2;
          q.offer(new Position(p.x, p.y - 1));
        }
        q.poll();
      }
    }
    return -1;
  }
  public static int orangeRotting(int[][] grid) {
    Queue<Position> queue = new LinkedList<>();
    int totalOranges = 0;
    int rottenOrange =0;
    int timeToRotten = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 || grid[i][j] == 2)
          totalOranges++;
        if (grid[i][j] == 2)
          queue.offer(new Position(i, j));
      }
    }
    if (totalOranges == 0) return 0;

    while (!queue.isEmpty() && rottenOrange < totalOranges) {
      int size = queue.size();
      rottenOrange += size;
      if (rottenOrange == totalOranges)
        return timeToRotten;
      timeToRotten++;
      for (int i = 0; i < size; i++) {
        Position position = queue.peek();
        assert position != null;
        if (position.x + 1 < grid.length && grid[position.x + 1][position.y] == 1) {
          grid[position.x + 1][position.y] = 2;
          queue.offer(new Position(position.x + 1, position.y));
        }
        if (position.x - 1 >= 0 && grid[position.x - 1][position.y] == 1) {
          grid[position.x - 1][position.y] = 2;
          queue.offer(new Position(position.x - 1, position.y));
        }
        if (position.y + 1 < grid[0].length && grid[position.x][position.y + 1] == 1) {
          grid[position.x][position.y + 1] = 2;
          queue.offer(new Position(position.x, position.y + 1));
        }
        if (position.y - 1 >= 0 && grid[position.x][position.y - 1] == 1) {
          grid[position.x][position.y - 1] = 2;
          queue.offer(new Position(position.x, position.y - 1));
        }
        queue.poll();
      }
    }
    return -1;
  }
}
