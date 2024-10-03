package ferreiras.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row
and maximum in its column.



Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.


Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
 */
public class ArrayLuckyNumber {
  public static void main(String[] args) {

    int[][] matrix = {
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
    };
    List<Integer> list = luckyNumbers(matrix);
    System.out.println(list);
  }

  public static List<Integer> luckyNumbers (int[][] matrix) {

    int row = matrix.length;
    int column = matrix[0].length;

    int[] min = new int[row];
    int[] max = new int[column];

    Arrays.fill(min, Integer.MAX_VALUE);

    for (int indexRow = 0; indexRow < row; indexRow++) {

      for (int indexColumn = 0; indexColumn < column; indexColumn++) {

        int candidate = matrix[indexRow][indexColumn];
        min[indexRow] = Math.min(min[indexRow], candidate);
        max[indexColumn] = Math.max(max[indexColumn], candidate);

      }

    }



    for (int [] x : matrix) {
      System.out.println(Arrays.toString(x));
    }
    System.out.println("------------------------");
    System.out.println(Arrays.toString(min));
    System.out.println(Arrays.toString(max));
    System.out.println("------------------------");

    for (int indexRow = 0; indexRow < row; indexRow++) {

      for (int indexColumn = 0; indexColumn < column; indexColumn++) {

        int candidate = matrix[indexRow][indexColumn];
        if (candidate == min[indexRow] && candidate == max[indexColumn]) {
          return List.of(candidate);
        }

      }

    }

    return new ArrayList<>();
  }
}
