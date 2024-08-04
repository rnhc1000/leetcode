package org.ferreiras.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj)
 * such that row ri and column cj are equal.
 * A row and column pair is considered equal if they contain the same elements in the
 * same order (i.e., an equal array).
 * Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
 * Output: 1
 * Explanation: There is 1 equal row and column pair:
 * - (Row 2, Column 1): [2,7,7]
 * Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
 * Output: 3
 * Explanation: There are 3 equal row and column pairs:
 * - (Row 0, Column 0): [3,1,2,2]
 * - (Row 2, Column 2): [2,4,2,2]
 * - (Row 3, Column 2): [2,4,2,2]
 */
public class EqualRowColumnPairs {

  public static void main(String[] args) {
    int[][] grid = {
            {3, 1, 2, 2},
            {1, 4, 4, 5},
            {2, 4, 2, 2},
            {2, 4, 2, 2},
    };

    int response = numberOfPairs(grid);
    System.out.println(response);

  }
    public static int equalPairs(int[][] grid){
    List<List<Integer>> lists = new ArrayList<>();
      int countPairs = 0;
      int totalPairs = 0;
      for (int[] row : grid) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row.length - 1; i++) {
          if (row[i] == row[i + 1]) {
            countPairs+=1;
            list.add(i);
            list.add(i+1);
          }
        }
        lists.add(list);
        totalPairs += (countPairs > 0) ? 1 : 0;
      }
      return totalPairs;
    }

    public static int numberOfPairs(int[][] grid) {
      int len = grid.length;
      int count = 0;

      for (int ri = 0; ri < len; ri++) {
        for (int cj = 0; cj < len; cj++) {
          boolean isEqual = true;

          for (int i = 0; i < len; i++) {
            if (grid[ri][i] != grid[i][cj]) {
              isEqual = false;
              break;
            }
          }
          if (isEqual) count++;
        }
      }
      return count;
    }
  }
