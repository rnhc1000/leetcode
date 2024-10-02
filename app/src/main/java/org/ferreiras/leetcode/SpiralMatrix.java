package org.ferreiras.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a positive integer n, generate an n x n matrix filled with elements
from 1 to n2 in spiral order.

Example 1:

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:

Input: n = 1
Output: [[1]]

Constraints:

1 <= n <= 20
 */
public class SpiralMatrix {
  public static void main(String[] args) {
    int n = 3;
    List<List<Integer>> response = generateMatrix(n);
  }
  public static List<List<Integer>> generateMatrix(int n) {
    List<List<Integer>> list = new ArrayList<>();
    int squared = n * n;
    int row = 1;
    for (int i = 1; i <= n ; i++) {
      List<Integer> listAux = new  ArrayList<>();
      for (int j = row; j <= n ; j++) {
        listAux.add(j);
      }
      row++;
      list.add(listAux);
    }

    System.out.println(list);
    return list;
  }
}
