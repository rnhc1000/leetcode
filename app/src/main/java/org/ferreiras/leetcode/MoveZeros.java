package org.ferreiras.leetcode;
/**
 * Given an array numbers, write a function to move all 0's
 * to the end of it while maintaining the relative order of
 * the non-zero elements
 * Input : [0, 1, 0, 3, 12]
 * Output: [1, 3, 12, 0, 0]
 */

public class MoveZeros {

  public static void main(String[] args) {
    int[] numbers = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0};
    int[] movedArray = moveZeros(numbers);
    System.out.print("[");
    for (int j : movedArray){
      System.out.print(" " + j + ",");
    }
    System.out.print("]");
  }

  public static int[] moveZeros(int[] numbers) {
    int size = numbers.length;
    int[] movedZerosToRight = new int[size];
    int countNonZero = 0;
    for (int number : numbers) {
      if (number != 0) {
        movedZerosToRight[countNonZero] = number;
        countNonZero++;
      }
    }
    return movedZerosToRight;
  }
}
