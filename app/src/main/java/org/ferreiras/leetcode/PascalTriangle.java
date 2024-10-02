package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown
Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]


Constraints:

0 <= rowIndex <= 33
 */
public class PascalTriangle {
  public static void main(String[] args) {
    int index = 3;
    List<Integer> response = getRow(index);
    System.out.println(response);
  }

  public static List<Integer> getRow(int rowIndex) {
    List<Integer> response = new ArrayList<>();

    if (rowIndex == 0) return List.of(1);
    if (rowIndex == 1) return List.of(1, 1);
    long row = 1L;

    response.add((int) row);

    for (int i = 1; i <= rowIndex; i++) {

      row = row * (rowIndex + 1 - i) / i;
      response.add((int) row);

    }

    return response;
  }

}
